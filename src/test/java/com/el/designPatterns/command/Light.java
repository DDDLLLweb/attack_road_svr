package com.el.designPatterns.command;

/**
 * @author Danfeng
 * @since 2018/11/23
 */
public class Light {
    String log = "";

    public Light(String log) {
        this.log = log;
    }

    public void on() {
        System.out.println(log + " on");
    }

    public void off() {
        System.out.println(log + " off");
    }

}
