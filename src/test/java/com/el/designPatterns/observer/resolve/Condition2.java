package com.el.designPatterns.observer.resolve;

import java.util.Random;

/**
 * @author Danfeng
 * @since 2018/11/18
 */
public class Condition2 implements Observer {

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
        System.out.println("*** Tomorrow mTemperature: " + mTemperature * new Random().nextFloat() + "***");
        System.out.println("*** Tomorrow mPressure: " + mPressure * new Random().nextFloat() + "***");
        System.out.println("*** Tomorrow mHumidity: " + mHumidity * new Random().nextFloat() + "***");
    }

}
