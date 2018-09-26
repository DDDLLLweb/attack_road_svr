package com.el.Thread;

/**
 * 线程A
 * @author Danfeng
 * @since 2018/5/24
 */
public class ThreadA extends Thread{
    private MyList list;

    public ThreadA(MyList list,String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                list.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
