package com.el.designPatterns.command.resolve;

/**
 * 命令接口
 *
 * @author Danfeng
 * @since 2018/11/26
 */
public interface Command {

    void execute();

    void undo();

}
