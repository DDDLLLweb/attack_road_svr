package com.el.designPatterns.observer.resolve;

/**
 * @author Danfeng
 * @since 2018/11/18
 */
public class Condition1 implements Observer {

    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    @Override
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
