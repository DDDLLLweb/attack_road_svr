package com.el.designPatterns.bridge.resolve;

import com.el.designPatterns.bridge.LgControl;
import com.el.designPatterns.bridge.SonyControl;

/**
 * @author Danfeng
 * @since 2019/1/5
 */
public class Test {
    public static void main(String[] args) {
        TvControl lg = new TvControl(new LgControl());
        TvControl sony = new TvControl(new SonyControl());
        lg.onOff();
        lg.nextChannel();
        lg.nextChannel();
        lg.preChannel();
        lg.onOff();
        sony.onOff();
        sony.nextChannel();
        sony.nextChannel();
        sony.preChannel();
        sony.onOff();
    }
}
