package com.el.designPatterns.decorate;

/**
 * @author Danfeng
 * @since 2018/11/20
 */
public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        super.setPrice(3.0f);
    }

}
