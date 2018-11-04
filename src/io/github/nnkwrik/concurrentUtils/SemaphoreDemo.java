package io.github.nnkwrik.concurrentUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author nnkwrik
 * @date 18/11/04 13:08
 */
public class SemaphoreDemo {

    private static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " =====> 获取许可");
                System.out.println(Thread.currentThread().getName() + "        执行中");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " <===== 释放许可");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }
    }


}
