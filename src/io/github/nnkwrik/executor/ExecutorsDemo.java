package io.github.nnkwrik.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author nnkwrik
 * @date 18/11/04 14:54
 */
public class ExecutorsDemo {

    public static void main(String[] args) {
        testExecutor();
//        testStopExecutor(3);
//        testStopExecutor(7);

    }

    public static void testExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        executor.shutdown();    //显示停止executor
    }

    public static void testStopExecutor(int time) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                System.err.println("任务被打断了");
            }
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });


        //安全停止
        try {
            System.out.println("尝试终止executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);// 5秒内尝试终止,期间会阻塞当前线程

        } catch (InterruptedException e) {
            System.err.println("终止行为被中断");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("强制终止未结束的任务");
            }
            executor.shutdownNow();
            System.out.println("终止完毕");
        }

    }

}
