package com.el.designPatterns.decorate;

/**
 * @author Danfeng
 * @since 2018/11/20
 */
public abstract class Drink {

    public String descripition = "";

    private float price = 0f;

    public String getDescripition() {
        return descripition + "-" + this.getPrice();
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
