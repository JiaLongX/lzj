package com.example.lzjproductdetails.dao;


import com.example.lzjpojo.Item;

/**
 * 商品详情服务数据层
 */
public interface ProductDetailsDao {

    Item selectItemById(String id);

}