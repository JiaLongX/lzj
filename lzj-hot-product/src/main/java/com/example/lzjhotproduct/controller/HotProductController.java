package com.example.lzjhotproduct.controller;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjhotproduct.service.HotProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("hotProduct")
public class HotProductController {

    @Resource
    private HotProductService hotProductService;

    @RequestMapping
    public LzjResult selectHotProduct(String city){
        return hotProductService.selectHotProduct(city);
    }
}
