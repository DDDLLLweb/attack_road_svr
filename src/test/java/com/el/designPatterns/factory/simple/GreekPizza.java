package com.el.designPatterns.factory.simple;

/**
 * @author Danfeng
 * @since 2018/11/22
 */
public class GreekPizza extends SimplePizza {
    @Override
    public void prepare() {
        super.setName("GreekPizza");
        System.out.println(name + "preparing");
    }
}
