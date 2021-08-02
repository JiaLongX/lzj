package com.example.lzjsearch.controller;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjsearch.service.SearchForESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 搜索服务控制层
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchForESService searchForESService;

    /**
     * 分页、高亮查询商品集合
     *
     * @param city
     * @param content
     * @param page
     * @param size
     * @return
     */
    @GetMapping("")
    public LzjResult selectItemForPage(String city, String content, int page, @RequestParam(defaultValue = "4") int size) {
        return searchForESService.selectItemForPage(city, content, page, size);
    }

}