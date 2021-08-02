package com.example.lzjrecommedation.service.impl;


import com.example.lzjcommons.result.LzjResult;
import com.example.lzjpojo.Item;
import com.example.lzjrecommedation.dao.RecommendationDao;
import com.example.lzjrecommedation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 热门推荐服务业务逻辑层
 */
@Service
public class RecommendationSeviceImpl implements RecommendationService {

    @Autowired
    private RecommendationDao recommendationDao;

    @Value("${fastdfs.storage.nginx.prefix}")
    private String fastdfsStorageNginxPrefix;

    /**
     * 查询商品列表
     * 1. 入参 String city
     * 2. 根据销量倒序查询，获取前 4 个
     * 3. 必须且只能显示 4 个，不足时获取其他城市补足
     *
     * @param city
     * @return
     */
    @Override
    public LzjResult selectRecommendationList(String city) {
        // 初始化 Query 查询对象
        Query query = new Query();
        // 构建查询对象
        Criteria c = new Criteria();
        // select * from item where city = 入参 and recommendation = true
        // 查询条件， 城市 = 参数值 and 是否推荐 = true
        c.andOperator(
                Criteria.where("city").is(city),
                Criteria.where("recommendation").is(true)
        );
        query.addCriteria(c);
        // 排序和分页
        query.with(
                PageRequest.of(0, 4,
                        Sort.by(Sort.Direction.DESC, "recoSort"))
        );
        // 查询结果可能不满足 4 个
        List<Item> itemList = recommendationDao.selectRecommendationList(query);// 假设查到 2 个
        // 错误返回
        if (itemList == null) {
            return LzjResult.error();
        }
        // 必须且只能显示 4 个，不足时获取其他城市补足
        if (itemList.size() < 4) {
            // 重新初始化查询对象
            Query otherQuery = new Query();
            // 构建查询对象
            Criteria c2 = new Criteria();
            // select * from item where city != 入参 and recommendation = true
            // 查询条件， 城市 = 参数值 and 是否推荐 = true
            c2.andOperator(
                    Criteria.where("city").ne(city),
                    Criteria.where("recommendation").is(true)
            );
            otherQuery.addCriteria(c2);
            // 排序和分页
            otherQuery.with(
                    PageRequest.of(0, 4 - itemList.size(),
                            Sort.by(Sort.Direction.DESC, "recoSort"))
            );
            itemList.addAll(recommendationDao.selectRecommendationList(otherQuery));
        }
        // 优化图片地址
        List<Item> resultItemList = changeItemList(itemList);
        // 成功返回
        return LzjResult.success("查询成功", resultItemList);
    }

    // 优化图片地址
    private List<Item> changeItemList(List<Item> itemList) {
        for (Item item : itemList) {
            List<String> newImgs = new ArrayList<>();
            for (String img : item.getImgs()) {
                newImgs.add(fastdfsStorageNginxPrefix + img);
            }
            item.setImgs(newImgs);
        }
        return itemList;
    }

}