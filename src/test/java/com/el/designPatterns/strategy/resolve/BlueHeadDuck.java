package com.el.designPatterns.strategy.resolve;

/**
 * @author Danfeng
 * @since 2018/11/17
 */
public class BlueHeadDuck extends ResolveDuck {

    @Override
    public void display() {
        System.out.println("im blue duck...");
    }

    public BlueHeadDuck() {
        flyBehavior = new GoodFlyBehavior();
        quackBehavior = new GaGaQuackBehavior();
    }

}
