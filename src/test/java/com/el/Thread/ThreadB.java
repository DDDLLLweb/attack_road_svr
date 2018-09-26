package com.el.Thread;

/**
 * 线程A
 * @author Danfeng
 * @since 2018/5/24
 */
public class ThreadB extends Thread{
    private MyList list;

    public ThreadB(MyList list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        try {
            //凭借 线程B 不断地通过 while语句轮询 来检测某一个条件，这样会导致CPU的浪费
            while (true) {          // while 语句轮询
                if (list.size() == 2) {
                    System.out.println("==2了，线程b要退出了！");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
