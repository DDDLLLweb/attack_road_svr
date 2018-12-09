package com.el.designPatterns.template.resolve;


/**
 * @author Danfeng
 * @since 2018/12/4
 */
public class Coffee extends HotDrink {

    @Override
    public void brewItem() {
        System.out.println("Brewing coffee");
    }

    public void addSugarMilk() {
        System.out.println("ADD Sugar");
    }

}
