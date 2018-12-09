package com.el.designPatterns.command;

/**
 * @author Danfeng
 * @since 2018/11/23
 */
public class Stereo {
    static int volume = 0;

    public void on() {
        System.out.println("Stereo on");
    }

    public void off() {
        System.out.println("Stereo off");
    }

    public void setCd() {
        System.out.println("Stereo setCd");
    }

    public void setVol(int vol) {
        volume = vol;
        System.out.println("Stereo volume=" + volume);
    }

    public int getVol() {
        return volume;
    }

    public void start() {
        System.out.println("Stereo start");
    }
}
