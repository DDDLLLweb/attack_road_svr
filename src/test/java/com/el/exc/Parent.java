package com.el.exc;

import groovy.transform.builder.Builder;

/**
 * @author Danfeng
 * @since 2018/7/20
 */
@Builder
public class Parent {
    protected String test1;
    public Parent() {
        test1 = "test1---==>"+System.currentTimeMillis();
    }
}
