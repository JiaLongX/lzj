package com.example.lzjcomment.service.impl;

import com.example.lzjcomment.dao.CommentDao;
import com.example.lzjcomment.service.CommentService;
import com.example.lzjcommons.result.LzjResult;
import com.example.lzjpojo.Comment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Override
    public LzjResult findCommentByItemId(String id, int page, int size) {
        Query query = new Query();
        query.addCriteria(Criteria.where("itemId").is(id));
        query.with(PageRequest.of(page, size));
        List<Comment> comments = commentDao.selectCommentList(query);
        LzjResult lzjResult = LzjResult.success("success", comments);
        if (comments.size()>0) {
            Long aLong = commentDao.countByQuery(id);
            if (aLong> (long) (page + 1) *size) {
                lzjResult.setHasMore(true);
            }
            return lzjResult;
        }
        return LzjResult.error();
    }
}
