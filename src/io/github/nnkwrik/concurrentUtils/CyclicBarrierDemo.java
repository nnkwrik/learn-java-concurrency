package io.github.nnkwrik.concurrentUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author nnkwrik
 * @date 18/11/04 13:26
 */
public class CyclicBarrierDemo {
    public static final int THREAD_NUM = 3;
    private static CyclicBarrier signal = new CyclicBarrier(THREAD_NUM,//填入要进行倒计时的线程的数量
            () -> System.out.println("======> 开始！"));   //当所有线程都到达临界点时会执行这条Runnable

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 2;

            try {
                while (num-- > 0) { //执行num次
                    System.out.println(Thread.currentThread().getName() + "等待开始");
                    signal.await();    //直到所有线程都到达这里
                    System.out.println(Thread.currentThread().getName() + "开始了");
                    //等待1~5秒
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                    System.out.println(Thread.currentThread().getName() + "结束了");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        };

        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(runnable).start();
        }

    }

}
