package com.el.Thread.util;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Danfeng
 * @since 2019/2/19
 */
public class CountDownLockTest implements Runnable {

    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLockTest t1 = new CountDownLockTest();

    @Override
    public void run() {

        try {
            // 模拟检查任务
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(t1);
        }
        // 等到检查
        end.await();
        System.out.println("Fire !!!");
        // 火箭发射
        executorService.shutdown();
    }

}
