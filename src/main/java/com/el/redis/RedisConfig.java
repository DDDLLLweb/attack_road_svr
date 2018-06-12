package com.el.redis;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author danfeng
 * @since 2018/2/27.
 *
 * redis 命令
 * flushdb : 清空当前数据库
 * select[index]: 选择索引数据库，index为索引值名，如：select 1
 * del[key]: 删除一条指定key的值
 * keys * 查看数据库内所有的key
 * flushall: 清空所有数据库
 * quit: 退出数据库
 */
@Slf4j
@Configuration
public class RedisConfig {

    @Bean("objectRedisTemplate")
    public ObjectRedisTemplate objectRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("[CORE-REDIS] redisTemplate");
        val objectRedisTemplate = new ObjectRedisTemplate();
        objectRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return objectRedisTemplate;
    }

//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        log.info("[CORE-REDIS] redisTemplate");
//        return new RedisCacheManager(redisTemplate);
//    }
}
