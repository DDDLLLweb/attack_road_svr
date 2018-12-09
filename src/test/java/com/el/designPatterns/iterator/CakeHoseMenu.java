package com.el.designPatterns.iterator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/5
 */
public class CakeHoseMenu {

    @Getter
    private List<MenuItem> menuItems;

    public CakeHoseMenu() {
        menuItems = new ArrayList<>();
        addItem("KFC", "Boiled eggs&toast&cabbage", true, 3.99f);
        addItem("KFC1", "Boiled eggs&toast&cabbage1", false, 4.99f);
        addItem("KFC2", "Boiled eggs&toast&cabbage2", true, 5.99f);
        addItem("KFC3", "Boiled eggs&toast&cabbage3", true, 6.99f);
    }

    private void addItem(String name, String description, boolean vegetable, float price) {
        MenuItem menuItem = new MenuItem(name, description, vegetable, price);
        menuItems.add(menuItem);
    }
}
