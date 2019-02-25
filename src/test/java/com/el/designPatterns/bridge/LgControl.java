package com.el.designPatterns.bridge;

/**
 * @author Danfeng
 * @since 2019/1/5
 */
public class LgControl implements Control {
    @Override
    public void on() {
        System.out.println("open Lg Tv");
    }

    @Override
    public void off() {
        System.out.println("Off Lg Tv");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("The Lg Tv set channel : " + channel);
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("The Lg Tv set volume : " + volume);

    }
}
