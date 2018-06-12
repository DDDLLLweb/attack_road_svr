package com.el.cache;

import org.springframework.cache.annotation.Cacheable;

import java.lang.annotation.*;

/**
 * @author danfeng
 * @since 2018/4/15
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Cacheable
public @interface CachePoint {

    String value() default "";

    /**
     * @return
     */
    boolean spel() default true;
}
