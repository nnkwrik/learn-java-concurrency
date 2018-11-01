package io.github.nnkwrik.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author nnkwrik
 * @date 18/11/01 17:54
 */
public class ReentrantLockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    private static int count = 0;

    private static void increment() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //每个线程分别执行3次 increment()
        Runnable runnable = () -> IntStream.range(0, 3)
//                                            .range(0, 10000)
                                            .forEach(i -> increment());

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println(count);
    }
}
