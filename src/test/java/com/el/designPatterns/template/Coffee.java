package com.el.designPatterns.template;

/**
 * @author Danfeng
 * @since 2018/12/4
 */
public class Coffee extends HotDrink{

    @Override
    public void prepareRecipe() {
        boilWater();
        brewCoffee();
        pourInCup();
        addSugarMilk();
    }

    public void brewCoffee(){
        System.out.println("Brewing coffee");
    }

    public void addSugarMilk() {
        System.out.println("ADD Sugar");
    }

}
