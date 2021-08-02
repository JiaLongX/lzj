package com.example.lzjhotproduct.service.impl;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjhotproduct.dao.HotProductDao;
import com.example.lzjhotproduct.service.HotProductService;
import com.example.lzjpojo.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotProductServiceImpl implements HotProductService {

    @Resource
    private HotProductDao hotProductDao;

    @Value("${fastdfs.storage.nginx.prefix:}")
    private String fastdfsStorageNginxPrefix;

    @Override
    public LzjResult selectHotProduct(String city) {
        Query query = new Query();
        query.addCriteria(Criteria.where("city").is(city));
        query.with(PageRequest.of(0,4, Sort.by(Sort.Direction.DESC,"sales")));
        List<Item> items=hotProductDao.selectHotProduct(query);
        if (items.size()>0) {
            if (items.size()<4) {
                Query query1 = new Query();
                query1.addCriteria(Criteria.where("city").ne(city));
                query1.with(PageRequest.of(0,4-items.size(),Sort.by(Sort.Direction.DESC,"sales")));
                List<Item> items1 = hotProductDao.selectHotProduct(query1);
                items.addAll(items1);
            }
            items = buildImgs(items);
            return LzjResult.success("success",items);
        }
        return LzjResult.error();
    }

    private List<Item> buildImgs(List<Item> items) {
        for (Item item : items) {
            List<String> itemImgs = new ArrayList<>();
            for (String img : item.getImgs()) {
                itemImgs.add(fastdfsStorageNginxPrefix+img);
            }
            item.setImgs(itemImgs);
        }
        return items;
    }
}
