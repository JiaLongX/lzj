package com.example.lzjsearch.service;

import com.example.lzjcommons.result.LzjResult;

/**
 * 搜索服务业务逻辑层
 */
public interface SearchForESService {

    /**
     * 分页、高亮查询商品集合
     *
     * @param city
     * @param content
     * @param page
     * @param size
     * @return
     */
    LzjResult selectItemForPage(String city, String content, int page, int size);

}