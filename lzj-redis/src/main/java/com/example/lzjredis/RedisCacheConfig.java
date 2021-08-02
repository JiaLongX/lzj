package com.example.lzjredis;

import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * Redis 缓存配置类，定义一个父类，用于提供模板配置
 */
public abstract class RedisCacheConfig {

    // 重写 RedisTemplate 序列化
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 为 String 类型 key 设置序列化器
        template.setKeySerializer(new StringRedisSerializer());
        // 为 String 类型 value 设置序列化器
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 为 Hash 类型 key 设置序列化器
        template.setHashKeySerializer(new StringRedisSerializer());
        // 为 Hash 类型 value 设置序列化器
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    // 重写 Cache 序列化
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(30L)) // 默认超时时间
                .disableCachingNullValues() // 不缓存空数据
                // 设置 key 和 value 的序列化
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(configuration)
                .build();
    }

}