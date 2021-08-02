package com.example.lzjbuytime.dao;


import com.example.lzjpojo.Item;

/**
 * 预订服务数据层
 */
public interface BuytimeDao {

    /**
     * 根据主键查询商品，然后获取可预订时间属性
     *
     * @param id
     * @return
     */
    Item selectItemById(String id);

}