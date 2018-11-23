package com.el.designPatterns.observer.resolve;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Danfeng
 * @since 2018/11/18
 */
public class WeatherDataSt implements Subject {

    private float mTemperature;
    private float mPressure;
    private float mHumidity;
    private List<Observer> mObservers;

    public WeatherDataSt() {
        mObservers = new ArrayList<>();
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

    public void setData(float mTemperature,
                        float mPressure,
                        float mHumidity) {
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        Objects.requireNonNull(observer);
        mObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        mObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        mObservers.forEach(observer -> observer.update(getmTemperature(), getmPressure(), getmHumidity()));
    }

}
