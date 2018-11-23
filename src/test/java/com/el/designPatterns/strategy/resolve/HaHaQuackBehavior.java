package com.el.designPatterns.strategy.resolve;

/**
 * @author Danfeng
 * @since 2018/11/17
 */
public class HaHaQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("HaHa");
    }
}
