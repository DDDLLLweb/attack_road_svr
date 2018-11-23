package com.el.designPatterns.singleTon;

/**
 * @author Danfeng
 * @since 2018/11/21
 */
public class SingleTon {
    private static SingleTon uniqueInstance = null;

    private SingleTon() {

    }

    public static SingleTon getInstance() {
        if (null == uniqueInstance) {
            uniqueInstance = new SingleTon();
        }
        return uniqueInstance;
    }
}
