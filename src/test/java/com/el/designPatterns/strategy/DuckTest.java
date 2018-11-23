package com.el.designPatterns.strategy;

/**
 * @author Danfeng
 * @since 2018/11/17
 */
public class DuckTest {
    public static void main(String[] args) {
        GreenHeadDuck greenHeadDuck = new GreenHeadDuck();
        greenHeadDuck.display();
        greenHeadDuck.quack();
        greenHeadDuck.swim();
        greenHeadDuck.fly();
        ReadHeadDuck readHeadDuck = new ReadHeadDuck();
        readHeadDuck.display();
        readHeadDuck.quack();
        readHeadDuck.swim();
        readHeadDuck.fly();
    }
}
