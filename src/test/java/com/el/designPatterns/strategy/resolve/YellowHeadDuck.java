package com.el.designPatterns.strategy.resolve;

/**
 * @author Danfeng
 * @since 2018/11/17
 */
public class YellowHeadDuck extends ResolveDuck {

    @Override
    public void display() {
        System.out.println("im yellow duck...");
    }

    public YellowHeadDuck() {
        flyBehavior = new NoFlyBehavior();
        quackBehavior = new HaHaQuackBehavior();
    }

}
