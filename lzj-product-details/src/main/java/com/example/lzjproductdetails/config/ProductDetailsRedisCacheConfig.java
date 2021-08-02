package com.example.lzjproductdetails.config;

import com.example.lzjredis.RedisCacheConfig;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * 商品详情缓存配置类
 */
@Configuration
public class ProductDetailsRedisCacheConfig extends RedisCacheConfig {

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