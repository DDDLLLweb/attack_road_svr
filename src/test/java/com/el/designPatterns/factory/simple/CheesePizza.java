package com.el.designPatterns.factory.simple;

/**
 * @author Danfeng
 * @since 2018/11/22
 */
public class CheesePizza extends SimplePizza {
    @Override
    public void prepare() {
        super.setName("CheesePizza");
        System.out.println(name + "preparing");
    }
}
