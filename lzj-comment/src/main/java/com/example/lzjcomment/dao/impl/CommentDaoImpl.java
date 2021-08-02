package com.example.lzjcomment.dao.impl;

import com.example.lzjcomment.dao.CommentDao;
import com.example.lzjpojo.Comment;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 商品评论服务数据层
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询商品评论
     *
     * @param query
     * @return
     */
    @Override
    public List<Comment> selectCommentList(Query query) {
        return mongoTemplate.find(query, Comment.class);
    }

    /**
     * 查询商品的评论总条数
     *
     * @param itemId
     * @return
     */
    @Override
    public Long countByQuery(String itemId) {
        // 创建聚合查询条件
        TypedAggregation<Comment> typedAggregation = new TypedAggregation<>(
                // 对应的具体类型
                Comment.class,
                // 提供聚合条件，group 分组，根据 itemId 字段分组，返回结果重命名为 count
                Aggregation.group("itemId").count().as("count")
        );
        // 聚合查询
        AggregationResults<Map> result = mongoTemplate.aggregate(typedAggregation, Map.class);
        // 处理分组数据，返回当前商品对应的评价总条数
        ArrayList<Document> resultList = (ArrayList<Document>) result.getRawResults().get("results");
        for (int i = 0; i < resultList.size(); i++) {
            Document document = resultList.get(i);
            if (itemId.equals(document.get("_id"))) {
                // 返回总条数
                return Long.parseLong(String.valueOf(document.get("count")));
            }
        }
        return 0L;
    }

}