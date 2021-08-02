package com.example.lzjcomment.dao;


import com.example.lzjpojo.Comment;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * 商品评论服务数据层
 */
public interface CommentDao {

    /**
     * 查询评论评论
     *
     * @param query
     * @return
     */
    List<Comment> selectCommentList(Query query);

    /**
     * 根据商品主键查询评论数量
     *
     * @param itemId
     * @return
     */
    Long countByQuery(String itemId);

}