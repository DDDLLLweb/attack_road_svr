package com.el.designPatterns.command;

/**
 * @author Danfeng
 * @since 2018/11/23
 */
public interface Controller {
    void onButton(int slot);

    void offButton(int slot);
}
