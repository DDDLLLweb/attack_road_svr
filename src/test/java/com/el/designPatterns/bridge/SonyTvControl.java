package com.el.designPatterns.bridge;

/**
 * @author Danfeng
 * @since 2019/1/5
 */
public class SonyTvControl extends SonyControl implements TvControl {

    private static int ch = 0;
    private static boolean ison = false;

    @Override
    public void onOff() {
        if (ison) {
            ison = false;
            super.off();
        } else {
            ison = true;
            super.on();
        }
    }

    @Override
    public void nextChannel() {
        ch++;
        super.setChannel(ch);
    }

    @Override
    public void preChannel() {
        ch--;
        if (ch < 0) {
            ch = 200;
        }
        super.setChannel(ch);
    }
}
