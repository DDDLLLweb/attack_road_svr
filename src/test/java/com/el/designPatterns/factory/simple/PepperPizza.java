package com.el.designPatterns.factory.simple;

/**
 * @author Danfeng
 * @since 2018/11/22
 */
public class PepperPizza extends SimplePizza {
    @Override
    public void prepare() {
        super.setName("PepperPizza");
        System.out.println(name + "preparing");
    }
}
