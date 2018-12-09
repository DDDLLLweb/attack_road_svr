package com.el.designPatterns.command;

/**
 * @author Danfeng
 * @since 2018/11/23
 */
public class ControlTest {
    public static void main(String[] args) {
        Controller ctl = new TraditionControl(new Light("Bedroom"),new Stereo());
        ctl.onButton(0);
        ctl.offButton(0);
    }
}
