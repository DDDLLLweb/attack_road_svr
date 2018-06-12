package com.el.cache;

import org.springframework.cache.annotation.CacheEvict;

import java.lang.annotation.*;

/**
 * @author danfeng
 * @since 2018/4/15
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@CacheEvict
public @interface CachePointEvict {

    String value() default "";

    /**
     * @return
     */
    boolean spel() default true;
}
