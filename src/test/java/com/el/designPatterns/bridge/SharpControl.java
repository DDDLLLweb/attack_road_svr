package com.el.designPatterns.bridge;

/**
 * @author Danfeng
 * @since 2019/1/5
 */
public class SharpControl implements Control {
    @Override
    public void on() {
        System.out.println("open Sharp Tv");
    }

    @Override
    public void off() {
        System.out.println("Off Sharp Tv");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("The  Sharp Tv set channel : " + channel);
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("The  Sharp Tv set volume : " + volume);
    }
}
