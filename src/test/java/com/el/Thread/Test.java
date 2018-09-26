package com.el.Thread;

/**
 * @author Danfeng
 * @since 2018/5/24
 */
public class Test {
    public static void main(String[] args) {

        MyList service = new MyList();

        ThreadA a = new ThreadA(service,"A");
        ThreadB b = new ThreadB(service,"B");

        a.start();
        b.start();
    }
}
