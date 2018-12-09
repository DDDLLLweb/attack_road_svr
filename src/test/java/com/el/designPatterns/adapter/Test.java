package com.el.designPatterns.adapter;

/**
 * @author Danfeng
 * @since 2018/11/27
 */
public class Test {
    public static void main(String[] args) {
        GreenHeadDuck greenHeadDuck = new GreenHeadDuck();
        WildTurkey wildTurkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);
        greenHeadDuck.quack();
        greenHeadDuck.fly();
        wildTurkey.gobble();
        wildTurkey.fly();
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
