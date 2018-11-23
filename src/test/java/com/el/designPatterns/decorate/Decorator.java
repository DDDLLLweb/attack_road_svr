package com.el.designPatterns.decorate;

/**
 * @author Danfeng
 * @since 2018/11/20
 */
public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }

    public String getDescription() {
        return super.descripition + "-" + super.getPrice() + "&&" + drink.getDescripition();
    }
}
