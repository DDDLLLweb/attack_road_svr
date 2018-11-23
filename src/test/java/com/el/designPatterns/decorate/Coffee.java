package com.el.designPatterns.decorate;

/**
 * @author Danfeng
 * @since 2018/11/20
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }

}
