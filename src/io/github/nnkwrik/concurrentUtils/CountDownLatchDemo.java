package io.github.nnkwrik.concurrentUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author nnkwrik
 * @date 18/11/04 13:26
 */
public class CountDownLatchDemo {
    public static final int THREAD_NUM = 3;
    private static CountDownLatch startSignal = new CountDownLatch(1);
    private static CountDownLatch endSignal = new CountDownLatch(THREAD_NUM);   //填入要进行倒计时的线程的数量

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + "等待开始");
                startSignal.await();    //直到startSignal变成0后才继续执行
                System.out.println(Thread.currentThread().getName() + "开始了");
                //等待1~5秒
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,5000));
                System.out.println(Thread.currentThread().getName() + "结束了");
                endSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(runnable).start();
        }

        Thread.sleep(1000);
        System.out.println("======> 开始！");
        startSignal.countDown();
        endSignal.await();
        System.out.println("======> 结束！");
    }

}
