package com.el.designPatterns.decorate;

/**
 * @author Danfeng
 * @since 2018/11/20
 */
public class DecorateTest {
    public static void main(String[] args) {
        Drink order = new Decaf();
        order = new Milk(order);
        System.out.println(order.cost());
    }
}
