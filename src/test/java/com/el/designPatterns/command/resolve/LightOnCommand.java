package com.el.designPatterns.command.resolve;

import com.el.designPatterns.command.Light;

/**
 * @author Danfeng
 * @since 2018/11/26
 */
public class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
    }
}
