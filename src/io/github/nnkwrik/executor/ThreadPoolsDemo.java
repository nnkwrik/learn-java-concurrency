package io.github.nnkwrik.executor;

import java.util.concurrent.*;

/**
 * @author nnkwrik
 * @date 18/11/04 16:20
 */
public class ThreadPoolsDemo {

    public static void main(String[] args) throws InterruptedException {
        testNewCachedThreadPool();
//        testNewFixedThreadPool();
//        testNewScheduledThreadPool();
//        testNewSingleThreadPool();


    }

    public static void testNewCachedThreadPool() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.execute(() -> System.out.println(Thread.currentThread().getName() + " : " + index));
        }
        executor.shutdown();
    }

    public static void testNewFixedThreadPool() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            final int index = i;
            executor.execute(() -> System.out.println(Thread.currentThread().getName() + " : " + index));
        }
        executor.shutdown();
    }

    public static void testNewScheduledThreadPool() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        Runnable task = () -> System.out.println(Thread.currentThread().getName());
        int initialDelay = 0;
        int period = 1;
        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(5);
        executor.shutdown();
    }

    public static void testNewSingleThreadPool() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 6; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.execute(() -> System.out.println(Thread.currentThread().getName() + " : " + index));
        }
        executor.shutdown();
    }


}
