package com.el.designPatterns.command.resolve;

import com.el.designPatterns.command.Stereo;

/**
 * @author Danfeng
 * @since 2018/11/26
 */
public class StereoOffCommand implements Command {

    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {

    }
}
