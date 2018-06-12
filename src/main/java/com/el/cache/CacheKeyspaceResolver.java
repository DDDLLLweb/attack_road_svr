package com.el.cache;

import com.el.KeyspaceResolver;
import com.el.util.DevError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.expression.ExpressionException;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;

/**
 * @author danfeng
 * @since 2018/4/14
 * 1，@ReaquiredArgsConstructor 用于使用类中所有带有@NonNULL注解的或者带有final关键字修饰的成员变量生成对应的构造方法
 * 2，CacheResolver 用于自定义如何处理缓存，实现自定义的缓存解析器。
 * 3，KeyGenerator 用于统一自定义生成key
 */
@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class CacheKeyspaceResolver implements CacheResolver, KeyGenerator {

    private final ExpressionParser parser = new SpelExpressionParser();

    private final KeyspaceResolver keyspaceResolver;

    private final CacheManager cacheManager;

    private String keyspace() {
        return keyspaceResolver.cacheSpace() + ":";
    }

    private String resolveCacheName(final Class<?> targetClass) {
        final CacheName cacheName = targetClass.getAnnotation(CacheName.class);
        if (cacheName != null && StringUtils.hasText(cacheName.value())) {
            return keyspace() + cacheName.value();
        } else {
            return keyspace() + targetClass.getSimpleName();
        }
    }

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        return Collections.singletonList(cacheManager.getCache(resolveCacheName(context.getTarget().getClass())));
    }

    @Override
    public Object generate(Object target, Method method, Object... params) {
        if(method.getAnnotation(CachePointEvictAll.class)!=null) {
            log.trace("[CORE-CACHE] evict all");
            return ""; // evict all points of this cache
        }

        StringBuilder key = new StringBuilder();
        key.append(resolveCacheName(target.getClass()));
        final CachePoint point = method.getAnnotation(CachePoint.class);
        if (point != null && StringUtils.hasText(point.value())) {
            key.append(':').append(point.spel() ? evalSpEL(point.value(), params) : point.value());
        } else {
            final CachePointEvict evict = method.getAnnotation(CachePointEvict.class);
            if (evict != null && StringUtils.hasText(evict.value())) {
                key.append(':').append(evict.spel() ? evalSpEL(evict.value(), params) : evict.value());
            } else {
                throw DevError.unexpected("[CORE-CACHE] please use annotation: " +
                    "`@CachePoint` or `@CachePointEvict` or `@CachePointEvictAll`");
            }
        }
        final String keyString = key.toString();
        log.trace("[CORE-CACHE] generated key: {}", keyString);
        return keyString;
    }

    private Object evalSpEL(String spelKey, Object[] params) {
        final Object spelCtx = params.length == 0 ? null
            : (params.length == 1 ? params[0] : params);
        try {
            return parser.parseExpression(spelKey).getValue(spelCtx);
        } catch (ExpressionException e) {
            throw DevError.unexpected(e.getMessage());
        }
    }

}
