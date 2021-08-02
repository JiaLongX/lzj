package com.example.lzjrecommedation.dao.impl;


import com.example.lzjpojo.Item;
import com.example.lzjrecommedation.dao.RecommendationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 热门推荐服务数据层
 */
@Repository
public class RecommendationDaoImpl implements RecommendationDao {

    // 注入模板对象
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询商品列表
     *
     * @param query
     * @return
     */
    @Override
    public List<Item> selectRecommendationList(Query query) {
        return mongoTemplate.find(query, Item.class);
    }

}