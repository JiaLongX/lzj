package com.example.lzjbuytime.dao.impl;

import com.example.lzjbuytime.dao.BuytimeDao;
import com.example.lzjpojo.Item;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
@Repository
public class BuytimeDaoImpl implements BuytimeDao {

    @Resource
    private MongoTemplate mongoTemplate;


    @Override
    public Item selectItemById(String id) {
        return mongoTemplate.findById(id,Item.class);
    }
}
