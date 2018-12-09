package com.el.designPatterns.template;

/**
 * @author Danfeng
 * @since 2018/12/4
 */
public class Tea extends HotDrink {


    @Override
    public void prepareRecipe() {
        boilWater();
        brewTea();
        pourInCup();
        addLemon();
    }

    public void brewTea() {
        System.out.println("Brewing tea");
    }

    public void addLemon() {
        System.out.println("ADD Lemon");
    }

}
