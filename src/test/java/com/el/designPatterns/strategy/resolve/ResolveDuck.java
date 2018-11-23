package com.el.designPatterns.strategy.resolve;

/**
 * @author Danfeng
 * @since 2018/11/17
 */
public abstract class ResolveDuck {
    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;

    public ResolveDuck() {

    }

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }

    public abstract void display();

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
