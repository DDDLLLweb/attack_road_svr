package com.el.designPatterns.adapter;


/**
 * @author Danfeng
 * @since 2018/11/17
 */
public class GreenHeadDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("GaGa");
    }

    public void fly() {
        System.out.println("~~Duck fly ~~");
    }
}
