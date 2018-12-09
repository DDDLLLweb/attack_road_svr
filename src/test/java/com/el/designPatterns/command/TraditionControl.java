package com.el.designPatterns.command;

/**
 * @author Danfeng
 * @since 2018/11/23
 */
public class TraditionControl implements Controller {
    Light light;
    Stereo stereo;

    public TraditionControl(Light light, Stereo stereo) {
        this.light = light;
        this.stereo = stereo;
    }

    @Override
    public void onButton(int slot) {
        switch (slot) {
            case 0:
                light.on();
                break;
            case 1:
                stereo.on();
                break;
            case 2:
                int vol = stereo.getVol();
                if (vol < 11) {
                    stereo.setVol(++vol);
                }
                break;
        }
    }

    @Override
    public void offButton(int slot) {
        switch (slot) {
            case 0:
                light.off();
                break;
            case 1:
                stereo.off();
                break;
            case 2:
                int vol = stereo.getVol();
                if (vol > 0) {
                    stereo.setVol(--vol);
                }
                break;
        }
    }
}
