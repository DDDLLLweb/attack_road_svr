package com.el.designPatterns.factory.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Danfeng
 * @since 2018/11/22
 */
public class OrderPizza {
    public OrderPizza() {
        SimplePizza simplePizza = null;
        String pizzaType;
        do {
            pizzaType = getType();
            if (pizzaType.equals("cheese")) {
                simplePizza = new CheesePizza();
            } else if (pizzaType.equals("greek")) {
                simplePizza = new GreekPizza();
            } else if (pizzaType.equals("pepper")) {
                simplePizza = new PepperPizza();
            } else {
                break;
            }
            simplePizza.prepare();
            simplePizza.bake();
            simplePizza.cut();
            simplePizza.box();
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(
                System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();

            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
