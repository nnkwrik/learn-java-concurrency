package io.github.nnkwrik.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author nnkwrik
 * @date 18/11/01 17:54
 */
public class ReentrantLock2Demo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);  //保持1秒不放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("锁是否被占用： " + lock.isLocked());
            System.out.println("占用所的是否是我： " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("是否获取锁 ： " + locked);
        });

        t1.start();
        t2.start();

    }
}
