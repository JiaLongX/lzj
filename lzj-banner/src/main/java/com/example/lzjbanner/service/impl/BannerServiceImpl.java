package com.example.lzjbanner.service.impl;

import com.example.lzjbanner.dao.BannerDao;
import com.example.lzjbanner.service.BannerService;
import com.example.lzjcommons.result.LzjResult;
import com.example.lzjpojo.Banner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerDao bannerDao;

    @Value("${fastdfs.storage.nginx.prefix:}")
    private String fastdfsStorageNginxPrefix;

    @Override
    public LzjResult selectBannerList() {
        // 初始化 Query 查询对象
        Query query = new Query();
        // 根据创建时间倒序查询，获取前 6 个
        query.with(PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC, "createTime")));
        List<Banner> bannerList = bannerDao.selectBannerList(query);
        if (bannerList.size()>0) {
            List<String> imgsUrl = bannerList.stream().map(banner -> fastdfsStorageNginxPrefix + banner.getUrl()).collect(Collectors.toList());
            return LzjResult.success("success",imgsUrl);
        }
        return LzjResult.error();
    }
}
