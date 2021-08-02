package com.example.lzjbuytime.service.impl;

import com.example.lzjbuytime.dao.BuytimeDao;
import com.example.lzjbuytime.service.BuytimeService;
import com.example.lzjcommons.result.LzjResult;
import com.example.lzjpojo.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class BuytimeServiceImpl implements BuytimeService {

    @Resource
    private BuytimeDao buytimeDao;


    @Override
    public LzjResult buytime(String id) {
        Item item = buytimeDao.selectItemById(id);
        LzjResult result = LzjResult.error();
        if (item!=null&&item.getImgs()!=null) {
            result = LzjResult.success();
            result.setTime(item.getBuytime().getTime());
        }
        return result;
    }
}
