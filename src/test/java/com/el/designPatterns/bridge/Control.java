package com.el.designPatterns.bridge;

/**
 * @author Danfeng
 * @since 2019/1/5
 */
public interface Control {
    void on();

    void off();

    void setChannel(int channel);

    void setVolume(int volume);
}
