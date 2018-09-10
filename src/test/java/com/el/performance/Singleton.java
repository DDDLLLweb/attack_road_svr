package com.el.performance;

/**
 * 单例模式
 *
 * @author Danfeng
 * @since 2018/7/27
 */
public class Singleton {

    private Singleton() {
        System.out.println("私有的构造方法，创建单例的过程会比较慢");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
