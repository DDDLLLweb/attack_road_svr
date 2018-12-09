package com.el.designPatterns.adapter;

/**
 * @author Danfeng
 * @since 2018/11/27
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Go Go");
    }

    @Override
    public void fly() {
        System.out.println("i am fly a short distance");
    }
}
