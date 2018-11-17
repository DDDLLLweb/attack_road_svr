package com.el.exc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newCachedThreadPool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {
    // 继承Thread
    class Mythread extends Thread {
        public void run() {
            System.out.println("MyThread.run()");
        }
    }

    class MyRunnable implements Runnable {
        public void run() {
          System.out.println("MyRunnable.run()");
        }
    }

    class SomeCallable<V>  implements Callable<V> {
        @Override
        public V call() throws Exception {
            System.out.println("SomeCallable.run()");
            return null;
        }

    }

    @Test
    public void testRunnable() {
        Mythread myThread1 = new Mythread();
        myThread1.start();
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        /**
         * 可返回值的任务必须实现Callable接口。类似的，无返回值的任务必须实现Runnable接口。
         * 执行Callable任务后，可以获取一个Future的对象，在该对象上调用get就可以获取到Callable任务返回的Object了。
         * 注意：get方法是阻塞的，即：线程无返回结果，get方法会一直等待.
         * 再结合线程池接口ExecutorService就可以实现传说中有返回结果的多线程了。
         */
        Callable<Integer> oneCallable = new SomeCallable<>();
        FutureTask<Integer> oneTask = new FutureTask<>(oneCallable);
        Thread oneThread = new Thread(oneTask);
        oneThread.start();
    }

    class MyCallable implements Callable<Object> {
        private String taskNum;

        MyCallable(String taskNum) {
            this.taskNum = taskNum;
        }

        public Object call() throws Exception {
            System.out.println(">>>" + taskNum + "任务启动");
            Date dateTmp1 = new Date();
            Thread.sleep(1000);
            Date dateTmp2 = new Date();
            long time = dateTmp2.getTime() - dateTmp1.getTime();
            System.out.println(">>>" + taskNum + "任务终止");
            return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
        }
    }

    @Test
    public void testMultithreading() throws Exception {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();
        int taskSize = 5;
        // 创建固定数目线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
//        newCachedThreadPool();
//        创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。
//        如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
//        newScheduledThreadPool()
//        创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。

        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i + " ");
            // 执行任务并获取Future对象
            Future f = pool.submit(c);
            // System.out.println(">>>" + f.get().toString());
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【"
            + (date2.getTime() - date1.getTime()) + "毫秒】");
    }

    /**
     * Executors
     * 通常管理一个线程池，这样一来我们就不需要手动去创建新的线程。
     * 在不断地处理任务的过程中，线程池内部线程将会得到复用
     * 在我们可以使用一个executor service来运行
     * 和
     * 我们想在我们整个程序中执行的一样多的并发任务。
     * Executors类提供了便利的工厂方法来创建不同类型的 executor services。
     * 在这个示例中我们使用了一个单线程线程池的 executor
     */
    @Test
    public void testThread() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
//        代码运行的结果类似于上一个示例，但是当运行代码时，你会注意到一个很大的差别：
//        Java进程从没有停止！Executors必须显式的停止-否则它们将持续监听新的任务
//        ExecutorService提供了两个方法来达到这个目的—— shutdwon()会等待正在执行的任务执行完
//        而shutdownNow()会终止所有正在执行的任务并立即关闭execuotr。
//        executor通过等待指定的时间让当前执行的任务终止来“温柔的”关闭executor。
//        在等待最长5分钟的时间后，execuote最终会通过中断所有的正在执行的任务关闭
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    /**
     * Callable也是类似于runnables的函数接口，
     * 不同之处在于，Callable返回一个值。
     * Callbale也可以像runnbales一样提交给 executor services。
     * 但是callables的结果怎么办？因为submit()不会等待任务完成，
     * executor service不能直接返回callable的结果。
     * 不过，executor 可以返回一个Future类型的结果，它可以用来在稍后某个时间取出实际的结果。
     */
    @Test
    public void testCallable() throws Exception{
        Callable<Integer> task = () ->{
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);
        System.out.println("future done? " + future.isDone());

        Integer result = future.get();
        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);
    }

    /**
     * Executors支持通过invokeAll()一次批量提交多个callable。
     * 这个方法结果一个callable的集合，然后返回一个future的列表。
     * @throws Exception
     */
    @Test
    public void testBatch() throws Exception{
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
            () -> "task1",
            () -> "task2",
            () -> "task3");
//          返回一个Future 集合
        executor.invokeAll(callables)
            .stream()
            .map(future -> {
                try {
                    return future.get();
                }
                catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            })
            .forEach(System.out::println);

    }

}
