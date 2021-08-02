package com.example.lzjbuytime.service;

import com.example.lzjcommons.result.LzjResult;

/**
 * 预定服务业务逻辑层
 */
public interface BuytimeService {

    /**
     * 根据主键查询商品，然后获取可预订时间属性
     *
     * @param id
     * @return
     */
    LzjResult buytime(String id);

}