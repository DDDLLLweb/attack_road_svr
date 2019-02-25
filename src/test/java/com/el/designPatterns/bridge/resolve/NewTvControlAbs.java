package com.el.designPatterns.bridge.resolve;

import com.el.designPatterns.bridge.Control;

/**
 * @author Danfeng
 * @since 2019/1/5
 */
public class NewTvControlAbs extends TvControlAbs {
    public NewTvControlAbs(Control control) {
        super(control);
    }

    private static int ch = 0;
    private static int prech = 0;
    private static boolean ison = false;

    @Override
    public void onOff() {
        if (ison) {
            ison = false;
            control.off();
        } else {
            ison = true;
            control.on();
        }
    }

    @Override
    public void nextChannel() {
        ch++;
        control.setChannel(ch);
    }

    @Override
    public void preChannel() {
        ch--;
        if (ch < 0) {
            ch = 200;
        }
        control.setChannel(ch);
    }

    public void setChannel(int channel) {
        prech = channel;
        ch = channel;
        control.setChannel(channel);
    }


    public void back() {
        control.setChannel(prech);
    }

}
