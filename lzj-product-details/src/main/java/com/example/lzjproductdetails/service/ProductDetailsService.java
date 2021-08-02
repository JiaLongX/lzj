package com.example.lzjproductdetails.service;


import com.example.lzjpojo.Item;

/**
 * 商品详情服务业务逻辑层
 */
public interface ProductDetailsService {

    // 主键查询商品
    Item selectItemById(String id);

}