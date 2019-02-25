package com.el.designPatterns.bridge.resolve;

import com.el.designPatterns.bridge.Control;

/**
 * @author Danfeng
 * @since 2019/1/5
 */
public abstract class TvControlAbs {

    Control control;

    public TvControlAbs(Control control) {
        this.control = control;
    }

    abstract void onOff();

    abstract void nextChannel();

    abstract void preChannel();
}
