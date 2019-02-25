package com.el.Thread.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步工具
 * ReentrantLock
 * 1, 可重入: 单线程可重复进入，但要重复退出
 * 2, 可中断: lockInterruptibly()
 * 3, 可限时: 超时不能获得锁,就返回false,不会永久等待构成死锁
 * 4, 公平锁: 先来先得
 *
 * @author Danfeng
 * @since 2019/2/18
 */
public class ReenterLockTest {

    private static int j = 0;

    // simple
    static class ReenterLock1 implements Runnable {
        private static ReentrantLock reentrantLock = new ReentrantLock();

        @Override
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                reentrantLock.lock();
                try {
                    j++;
                } finally {
                    reentrantLock.unlock();
                }
            }
        }

    }

    // 可重入
    static class ReenterLock2 implements Runnable {
        private static ReentrantLock reentrantLock = new ReentrantLock();

        @Override
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                reentrantLock.lock();
                reentrantLock.lock();
                try {
                    j++;
                } finally {
                    reentrantLock.unlock();
                    // 会发生死锁
//                    reentrantLock.unlock();
                }
            }
        }

    }

    // 可中断
    static class ReenterLock3 implements Runnable {

        private static ReentrantLock lock1 = new ReentrantLock();
        private static ReentrantLock lock2 = new ReentrantLock();
        private int lock;

        public ReenterLock3(int lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                if (lock == 1) {
                    lock1.lockInterruptibly();
                    Thread.sleep(500);
                    lock2.lockInterruptibly();
                } else {
                    lock2.lockInterruptibly();
                    Thread.sleep(500);
                    lock1.lockInterruptibly();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getId() + " :线程退出");
            }
        }

    }

    // 可限时
    static class ReenterLock4 implements Runnable {
        private static ReentrantLock reentrantLock = new ReentrantLock();

        @Override
        public void run() {
            try {
                if (reentrantLock.tryLock(5, TimeUnit.SECONDS)) {
                    Thread.sleep(500);
                } else {
                    System.out.println("get lock failed");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }

    }


    static class ReenterLock5 implements Runnable {
        private static ReentrantLock reentrantLock = new ReentrantLock();
        private static Condition condition = reentrantLock.newCondition();

        @Override
        public void run() {
            try {
                reentrantLock.lock();
                condition.await();
                System.out.println("Thread is going on");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            ReenterLock5 reenterLock5 = new ReenterLock5();
            Thread t5 = new Thread(reenterLock5);
            t5.start();
            Thread.sleep(200);
            reentrantLock.lock();
            condition.signal();
            reentrantLock.unlock();
        }

    }


    public static void main(String[] args) throws InterruptedException {
//        ReenterLock1 test = new ReenterLock1();
//        Thread t1 = new Thread(test);
//        Thread t2 = new Thread(test);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println("====> " + j);
//        ReenterLock3 lock1 = new ReenterLock3(1);
//        ReenterLock3 lock2 = new ReenterLock3(2);
//        Thread t1 = new Thread(lock1);
//        Thread t2 = new Thread(lock2);
//        t1.start();
//        t2.start();
//        Thread.sleep(500);
        // 中断其中一个线程

//        ReenterLock4 lock4 = new ReenterLock4();
//        Thread t1 = new Thread(lock4);
//        Thread t2 = new Thread(lock4);
//        t1.start();
//        t2.start();


    }
}
