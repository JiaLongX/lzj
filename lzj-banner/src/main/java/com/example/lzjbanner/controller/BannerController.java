package com.example.lzjbanner.controller;

import com.example.lzjbanner.service.BannerService;
import com.example.lzjcommons.result.LzjResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("banner")
public class BannerController {

    @Resource
    private BannerService bannerService;

    @RequestMapping
    public LzjResult selectBannerList(){
        return bannerService.selectBannerList();
    }
}
