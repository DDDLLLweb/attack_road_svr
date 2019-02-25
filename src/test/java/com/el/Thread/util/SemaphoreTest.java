package com.el.Thread.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 共享锁
 * 运行多个线程同时临界区
 *
 * @author Danfeng
 * @since 2019/2/19
 */
public class SemaphoreTest {

    static class Semaphore1 implements Runnable {
        private Semaphore semaphore = new Semaphore(5);

        @Override
        public void run() {
            try {
                semaphore.acquire();
                // 模拟耗时操作
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getId() + " :done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }


        public static void main(String[] args) {
            ExecutorService service = Executors.newFixedThreadPool(20);

            final Semaphore1 semaphore1 = new Semaphore1();

            for (int i = 0; i < 20; i++) {
                service.submit(semaphore1);
            }
        }

    }


}
