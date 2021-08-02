package com.example.lzjhotproduct.dao.impl;

import com.example.lzjhotproduct.dao.HotProductDao;
import com.example.lzjpojo.Item;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class HotProductDaoImpl implements HotProductDao {

    @Resource
    private MongoTemplate mongoTemplate;


    @Override
    public List<Item> selectHotProduct(Query query) {
        return mongoTemplate.find(query,Item.class);
    }
}
