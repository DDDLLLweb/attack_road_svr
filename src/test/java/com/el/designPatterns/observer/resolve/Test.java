package com.el.designPatterns.observer.resolve;

import com.el.designPatterns.observer.WeatherData;

/**
 * @author Danfeng
 * @since 2018/11/18
 */
public class Test {
    public static void main(String[] args) {
        Condition1 condition1 = new Condition1();
        Condition2 condition2 = new Condition2();

        WeatherDataSt weatherDataSt = new WeatherDataSt();

        weatherDataSt.registerObserver(condition1);
        weatherDataSt.registerObserver(condition2);

        weatherDataSt.setData(10,20,30);

        weatherDataSt.removeObserver(condition1);
        weatherDataSt.setData(20,30,40);
    }
}
