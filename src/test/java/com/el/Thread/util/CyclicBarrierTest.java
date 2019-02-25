package com.el.Thread.util;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Danfeng
 * @since 2019/2/19
 */
public class CyclicBarrierTest {
    public static class Solider implements Runnable {
        private String soliderName;
        private final CyclicBarrier cyclicBarrier;

        Solider(CyclicBarrier cyclicBarrier, String soliderName) {
            this.cyclicBarrier = cyclicBarrier;
            this.soliderName = soliderName;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

        public void doWork() {
            try {
                Thread.sleep(new Random().nextInt(10) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static class BarrierRun implements Runnable {

        boolean flag;
        int N;

        BarrierRun(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令：【士兵】" + N + "个，任务完成！");
            } else {
                System.out.println("司令：【士兵】" + N + "个，集合完毕！");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        boolean flag = false;
        Thread[] allSoliders = new Thread[N];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        // 设置屏障点，主要为了执行这个方法
        System.out.println("集合队伍！！！");
        for (int i = 0; i < N; i++) {
            System.out.println("士兵 " + i + "报道");
            allSoliders[i] = new Thread(new Solider(cyclicBarrier, "士兵" + i));
            allSoliders[i].start();
            if (i == 5) {
                allSoliders[0].interrupt();
            }
        }
    }

}
