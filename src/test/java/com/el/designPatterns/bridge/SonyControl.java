package com.el.designPatterns.bridge;

/**
 * @author Danfeng
 * @since 2019/1/5
 */
public class SonyControl implements Control {
    @Override
    public void on() {
        System.out.println("open Sony Tv");
    }

    @Override
    public void off() {
        System.out.println("Off Sony Tv");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("The  Sony Tv set channel : "+channel);
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("The  Sony Tv set volume : "+volume);
    }
}
