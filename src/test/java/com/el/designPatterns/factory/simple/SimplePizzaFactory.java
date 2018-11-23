package com.el.designPatterns.factory.simple;

/**
 * @author Danfeng
 * @since 2018/11/22
 */
public class SimplePizzaFactory {

    public SimplePizza createPizza(String pizzaType) {
        SimplePizza simplePizza = null;
        if (pizzaType.equals("cheese")) {
            simplePizza = new CheesePizza();
        } else if (pizzaType.equals("greek")) {
            simplePizza = new GreekPizza();
        } else if (pizzaType.equals("pepper")) {
            simplePizza = new PepperPizza();
        }
        return simplePizza;
    }

}
