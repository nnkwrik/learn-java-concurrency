package io.github.nnkwrik.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author nnkwrik
 * @date 18/11/04 15:43
 */
public class ScheduledExecutorDemo {

    public static void main(String[] args) throws InterruptedException {
        testScheduledExecutor();
//        testScheduleAtFixedRate();
//        testBadScheduleAtFixedRate();
//        testBadScheduleWithFixedRate();
    }

    public static void testScheduledExecutor() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduling " + System.nanoTime());
        int delay = 3;
        ScheduledFuture<?> schedule = executor.schedule(task, delay, TimeUnit.SECONDS);
        TimeUnit.MILLISECONDS.sleep(1337);
        System.out.println("剩余延迟" + schedule.getDelay(TimeUnit.MILLISECONDS));
        executor.shutdown();
    }

    public static void testScheduleAtFixedRate() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling " + System.nanoTime());
        int initialDelay = 0;
        int period = 1;
        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }


    public static void testBadScheduleAtFixedRate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        long startTime = System.nanoTime();
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long time  = TimeUnit.SECONDS.convert(System.nanoTime() - startTime ,TimeUnit.NANOSECONDS);
            System.out.println("Scheduling " + time);
        };

        int initialDelay = 0;
        int period = 1;
        //不会延迟等待1秒，在2秒过后直接进入下一个2秒
        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }

    public static void testBadScheduleWithFixedRate(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        long startTime = System.nanoTime();
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long time  = TimeUnit.SECONDS.convert(System.nanoTime() - startTime ,TimeUnit.NANOSECONDS);
            System.out.println("Scheduling " + time);
        };

        int initialDelay = 0;
        int period = 1;
        //延迟等待1秒，在2秒过后直接等1秒，再进进入下一个2秒
        executor.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.SECONDS);
    }


}
