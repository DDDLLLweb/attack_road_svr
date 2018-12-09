package com.el.designPatterns.iterator;

import lombok.Data;

/**
 * @author Danfeng
 * @since 2018/12/5
 */
@Data
public class MenuItem {

    private String name, description;

    private boolean vegetable;

    private float price;

    public MenuItem(String name,String description, boolean vegetable, float price) {
        this.name = name;
        this.description = description;
        this.vegetable = vegetable;
        this.price = price;
    }

}
