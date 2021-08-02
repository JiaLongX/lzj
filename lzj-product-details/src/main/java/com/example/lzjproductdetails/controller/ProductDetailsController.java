package com.example.lzjproductdetails.controller;

import com.example.lzjpojo.Item;
import com.example.lzjproductdetails.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品详情服务控制层
 */
@RestController
@RequestMapping("/details")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;

    /**
     * 商品详情查询方法。主键查询商品。
     *
     * @param id
     * @return
     */
    @GetMapping
    public Item selectItemById(String id) {
        return productDetailsService.selectItemById(id);
    }

}