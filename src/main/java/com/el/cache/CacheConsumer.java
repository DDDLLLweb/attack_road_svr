package com.el.cache;

import com.el.util.DevError;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheResolver;

import java.util.Collections;

/**
 * @author danfeng
 * @since 2018/2/27.
 */
public interface CacheConsumer {
    String cacheName();

    /**
     * context中存放了当前cache的操作类型、目标对象、目标方法、参数信息，这样我们可以根据这些信息来决定使用那些cache；
     * context.getOperation().getCacheNames()得到当前目标对象/目标方法上配置的cache Name；
     * 然后我们可以在此基础上添加额外的cache
     * 此处需要注意的是即使配置了CacheResolver，
     * 也必须在@CacheConfig或方法上的如@CachePut上指定至少一个Cache Name。
     */
    static CacheResolver createCacheResolver(CacheManager cacheManager) {
        return (context) -> {
            Object target = context.getTarget();
            if (target instanceof CacheConsumer) {
                Cache cache = cacheManager.getCache(((CacheConsumer) target).cacheName());
                return Collections.singletonList(cache);
            } else {
                throw DevError.unexpected(target.getClass().getName() + " must implement interface com.el.core.cache.CacheConsumer.");
            }
        };
    }
}
