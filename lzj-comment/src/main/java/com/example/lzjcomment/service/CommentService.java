package com.example.lzjcomment.service;

import com.example.lzjcommons.result.LzjResult;

public interface CommentService {
    LzjResult findCommentByItemId(String id, int page, int size);
}
