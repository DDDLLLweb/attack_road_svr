package com.el.designPatterns.template.resolve;

/**
 * @author Danfeng
 * @since 2018/12/4
 */
public abstract class HotDrink {

    public void prepareRecipe(){
        boilWater();
        brewItem();
        pourInCup();
        addSugarMilk();
    }

    public abstract void brewItem();
    public abstract void addSugarMilk();

    public final void boilWater() {
        System.out.println("Boiling water");
    }

    public final void pourInCup() {
        System.out.println("Pour in Cup");
    }
}
