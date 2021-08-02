package com.example.lzjsendyzm.service.impl;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjpojo.ValidateCode;
import com.example.lzjsendyzm.dao.SendyzmDao;
import com.example.lzjsendyzm.service.SendyzmService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SendyzmServiceImpl implements SendyzmService {

    @Resource
    private SendyzmDao sendyzmDao;
    @Resource
    private RedisTemplate<Object,String> redisTemplate;
    @Value("${lzj.cache.sendyzm.prefix}")
    private String sendyzmPrefix;

    @Override
    public LzjResult sendyzm(String phone) {
        UUID uuid = UUID.randomUUID();
        String substring = uuid.toString().substring(0, 4);
        System.out.println(substring);
        return sendyzmDao.setCode(phone,substring)?LzjResult.success("success"):LzjResult.error();
    }

    @Override
    public String getCode(String phone) {
        return sendyzmDao.getCode(phone);
    }

    @Override
    public LzjResult deleteCode(String phone) {
        return sendyzmDao.deleteCode(phone)?LzjResult.success("success"):LzjResult.error();
    }
}
