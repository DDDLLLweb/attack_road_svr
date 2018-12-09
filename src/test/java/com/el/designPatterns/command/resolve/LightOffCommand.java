package com.el.designPatterns.command.resolve;

import com.el.designPatterns.command.Light;

/**
 * @author Danfeng
 * @since 2018/11/26
 */
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
    }
}
