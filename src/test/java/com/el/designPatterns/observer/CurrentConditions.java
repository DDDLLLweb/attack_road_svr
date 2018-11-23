package com.el.designPatterns.observer;

/**
 * @author Danfeng
 * @since 2018/11/18
 */
public class CurrentConditions {
    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    public void update(float mTemperature, float mPressure, float mHumidity) {
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        display();
    }

    public void display() {
        System.out.println("*** Today mTemperature: " + mTemperature + "***");
        System.out.println("*** Today mPressure: " + mPressure + "***");
        System.out.println("*** Today mHumidity: " + mHumidity + "***");
    }

}
