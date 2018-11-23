package com.el.designPatterns.strategy;

/**
 * @author Danfeng
 * @since 2018/11/17
 */
public class GreenHeadDuck extends Duck {
    @Override
    public void display() {
        System.out.println("**GreenHead**");
    }

    public void fly() {
        System.out.println("~~ no fly ~~");
    }
}
