package com.el.designPatterns.observer;

/**
 * @author Danfeng
 * @since 2018/11/18
 */
public class WeatherData {
    private float mTemperature;
    private float mPressure;
    private float mHumidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public float getmTemperature() {
        return mTemperature;
    }

    public float getmPressure() {
        return mPressure;
    }

    public float getmHumidity() {
        return mHumidity;
    }

    public void dataChange() {
        currentConditions.update(mTemperature, mPressure, mHumidity);
    }

    public void setData(float mTemperature,
                        float mPressure,
                        float mHumidity) {
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        dataChange();
    }
}
