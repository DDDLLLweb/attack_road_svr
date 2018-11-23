package com.el.designPatterns.observer;

/**
 * @author Danfeng
 * @since 2018/11/18
 */
public class Test {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(10,20,30);
    }
}
