package com.el.designPatterns.command.resolve;

import com.el.designPatterns.command.Stereo;

/**
 * @author Danfeng
 * @since 2018/11/26
 */
public class StereoOnCommand implements Command {
    private Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
    }

    @Override
    public void undo() {

    }
}
