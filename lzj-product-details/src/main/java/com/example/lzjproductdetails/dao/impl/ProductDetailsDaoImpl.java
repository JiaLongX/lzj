package com.example.lzjproductdetails.dao.impl;

import com.example.lzjpojo.Item;
import com.example.lzjproductdetails.dao.ProductDetailsDao;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ProductDetailsDaoImpl implements ProductDetailsDao {

    @Resource
    private MongoTemplate mongoTemplate;


    @Override
    public Item selectItemById(String id) {
        return mongoTemplate.findById(id,Item.class);
    }
}
