package com.example.lzjsendyzm.config;

import com.example.lzjredis.RedisCacheConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 商品详情缓存配置类
 */
@Configuration
public class SendyzmRedisCacheConfig extends RedisCacheConfig {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 创建 RedisTemplate 模板对象
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> restTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(stringSerializer);
//        return redisTemplate;
        return super.redisTemplate(redisConnectionFactory);
    }

    /**
     * 创建缓存管理器。
     *
     * @param redisConnectionFactory Redis连接工厂
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return super.cacheManager(redisConnectionFactory);
    }

}