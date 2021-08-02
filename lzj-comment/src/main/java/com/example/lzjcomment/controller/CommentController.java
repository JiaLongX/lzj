package com.example.lzjcomment.controller;

import com.example.lzjcomment.service.CommentService;
import com.example.lzjcommons.result.LzjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品评论服务控制层
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public LzjResult selectCommentByItemId(String id, int page, @RequestParam(defaultValue = "4") int size) {
        return commentService.findCommentByItemId(id, page, size);
    }

}