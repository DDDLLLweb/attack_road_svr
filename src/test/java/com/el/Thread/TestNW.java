package com.el.Thread;

/**
 * @author Danfeng
 * @since 2018/5/24
 */
public class TestNW {
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        thread1.start();

        Thread.sleep(2000);

        thread2.start();
        thread3.start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程" + Thread.currentThread().getName()
                    + "获取到了锁...");
                try {
                    System.out.println("线程" + Thread.currentThread().getName()
                        + "阻塞并释放锁...");
                    //调用某个对象的 wait() 方法能让 当前线程阻塞，并且当前线程必须拥有此对象的monitor（即锁）
                    object.wait();
                    } catch (InterruptedException e) {
                }
                System.out.println("线程" + Thread.currentThread().getName()
                    + "执行完成...");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程" + Thread.currentThread().getName()
                    + "获取到了锁...");
                // 调用某个对象的 notify() 方法能够唤醒 一个正在等待这个对象的monitor的线程，如果有多个线程都在等待这个对象的monitor，则只能唤醒其中一个线程；
//                object.notify();
                try {
                    System.out.println("线程" + Thread.currentThread().getName()
                        + "阻塞并释放锁...");
                    //调用某个对象的 wait() 方法能让 当前线程阻塞，并且当前线程必须拥有此对象的monitor（即锁）
                    object.wait();
                } catch (InterruptedException e) {
                }
                System.out.println("线程" + Thread.currentThread().getName()
                    + "唤醒了正在wait的线程...");
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行完成...");
        }
    }

    static class Thread3 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程" + Thread.currentThread().getName()
                    + "获取到了锁...");
                // 调用某个对象的 notify() 方法能够唤醒 一个正在等待这个对象的monitor的线程，如果有多个线程都在等待这个对象的monitor，则只能唤醒其中一个线程；
                object.notifyAll();
                System.out.println("线程" + Thread.currentThread().getName()
                    + "唤醒了正在wait的线程...");
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行完成...");
        }
    }
}
