package com.el.designPatterns.strategy;

/**
 * @author Danfeng
 * @since 2018/11/17
 */
public abstract class Duck {

    public Duck() {

    }

    public void quack() {
        System.out.println("gaga");
    }

    public void swim() {
        System.out.println("~ ~ im swim ~~");
    }

    public void fly() {
        System.out.println("~ ~ im fly ~~");
    }

    public abstract void display();
}
