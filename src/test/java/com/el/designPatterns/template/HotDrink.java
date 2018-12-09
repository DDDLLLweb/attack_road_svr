package com.el.designPatterns.template;

/**
 * @author Danfeng
 * @since 2018/12/4
 */
public abstract class HotDrink {

    public abstract void prepareRecipe();

    public void boilWater() {
        System.out.println("Boiling water");
    }

    public void pourInCup() {
        System.out.println("Pour in Cup");
    }
}
