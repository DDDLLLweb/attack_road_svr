package com.el.designPatterns.bridge;

/**
 * @author Danfeng
 * @since 2019/1/5
 */
public class Test {
    public static void main(String[] args) {
        LgTvControl lgTvControl = new LgTvControl();
        SonyTvControl sonyTvControl = new SonyTvControl();
        lgTvControl.onOff();
        lgTvControl.nextChannel();
        lgTvControl.nextChannel();
        lgTvControl.preChannel();
        lgTvControl.onOff();
        sonyTvControl.onOff();
        sonyTvControl.nextChannel();
        sonyTvControl.nextChannel();
        sonyTvControl.preChannel();
        sonyTvControl.onOff();
    }
}
