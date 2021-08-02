package com.example.lzjrecommedation.controller;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjrecommedation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 热门推荐服务控制层
 */
@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("")
    public LzjResult selectRecommendationList(String city) {
        return recommendationService.selectRecommendationList(city);
    }

}