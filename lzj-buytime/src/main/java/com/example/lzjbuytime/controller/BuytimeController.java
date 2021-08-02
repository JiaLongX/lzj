package com.example.lzjbuytime.controller;

import com.example.lzjbuytime.service.BuytimeService;
import com.example.lzjcommons.result.LzjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 预定服务控制层
 */
@RestController
@RequestMapping("/buytime")
public class BuytimeController {

    @Autowired
    private BuytimeService buytimeService;

    /**
     * 根据主键查询商品，然后获取可预订时间属性
     *
     * @param id
     * @return
     */
    @GetMapping
    public LzjResult buytime(String id) {
        return buytimeService.buytime(id);
    }

}