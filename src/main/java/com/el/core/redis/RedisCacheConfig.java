package com.el.core.redis;

import com.el.common.KeyspaceResolver;
import com.el.core.cache.CacheKeyspaceResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

/**
 * @author danfeng
 * @since 2018/2/27.
 */
@Slf4j
@ConditionalOnBean(RedisConfig.class)
@EnableCaching
@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {

    /**
     * Redis 底层中存储的数据只是字节。虽然Redis本身支持各种类型，
     * 但在大多数情况下，这些指的是数据的存储方式，而不是他所代表的内容
     * 用户自己来决定数据如何被转换成String或任何其他对象，用户自定义
     * 类型和原始数据类型之间的互相转换通过RedisSerializer接口来处理
     * 它负责处理序列化/反序列化过程。多个实现可以开箱即用
     */
    @Autowired
    private ObjectRedisTemplate objectRedisTemplate;

    @Autowired
    private KeyspaceResolver keyspaceResolver;

    @Autowired
    private CacheManager cacheManager;

    @Bean
    public CacheKeyspaceResolver cachePointConsumer() {
        log.info("[CORE-CACHE] cachePointConsumer");
        return CacheKeyspaceResolver.of(keyspaceResolver, new RedisCacheManager(objectRedisTemplate));
    }

    @Override
    public CacheResolver cacheResolver() {
        return cachePointConsumer();
    }

    @Override
    public KeyGenerator keyGenerator() {
        return cachePointConsumer();
    }

    /**
     * CacheResolver
     * Cache解析器，用于根据实际情况来动态解析使用哪个Cache
     */
//    @Bean
//    public CacheResolver cacheResolver() {
//        log.info("[CORE-REDIS] cacheResolver");
//        return CacheConsumer.createCacheResolver(cacheManager());
//    }


//    @Bean
//    public CacheManager cacheManager() {
//        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//        //设置缓存过期时间
//        //rcm.setDefaultExpiration(60);//秒
//        return rcm;
//    }


}
