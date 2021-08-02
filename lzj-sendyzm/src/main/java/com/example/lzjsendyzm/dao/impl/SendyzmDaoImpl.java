package com.example.lzjsendyzm.dao.impl;

import com.example.lzjpojo.ValidateCode;
import com.example.lzjsendyzm.dao.SendyzmDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository
public class SendyzmDaoImpl implements SendyzmDao {

    @Resource
    private RedisTemplate<Object,String> redisTemplate;
    @Value("${lzj.cache.sendyzm.prefix}")
    private String sendyzmPrefix;

    @Override
    public Boolean setCode(String phone, String code) {
        return redisTemplate.opsForValue().setIfAbsent(sendyzmPrefix+phone,code,3, TimeUnit.MINUTES);
    }

    @Override
    public String getCode(String phone) {
        return redisTemplate.opsForValue().get(sendyzmPrefix+phone);
    }

    @Override
    public boolean deleteCode(String phone) {
        return redisTemplate.delete(sendyzmPrefix+phone);
    }
}
