package com.el.designPatterns.observer.resolve;

/**
 * @author Danfeng
 * @since 2018/11/18
 */
public interface Observer {
    void update(float mTemperature, float mPressure, float mHumidity);
}
