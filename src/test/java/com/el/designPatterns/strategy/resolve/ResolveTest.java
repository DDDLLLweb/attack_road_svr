package com.el.designPatterns.strategy.resolve;

/**
 * @author Danfeng
 * @since 2018/11/17
 */
public class ResolveTest {
    public static void main(String[] args) {
        ResolveDuck yellowHeadDuck = new YellowHeadDuck();
        yellowHeadDuck.display();
        yellowHeadDuck.quack();
        yellowHeadDuck.fly();
        ResolveDuck blueHeadDuck = new BlueHeadDuck();
        blueHeadDuck.display();
        blueHeadDuck.quack();
        blueHeadDuck.fly();
    }
}
