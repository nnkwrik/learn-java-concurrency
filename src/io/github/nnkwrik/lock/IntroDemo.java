package io.github.nnkwrik.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nnkwrik
 * @date 18/11/01 17:36
 */
public class IntroDemo {
    public Lock lock = new ReentrantLock();


    private void testLock(Thread thread) {
        lock.lock();
        try {
            System.out.println("线程名" + thread.getName() + "获得了锁");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("线程名" + thread.getName() + "释放了锁");
            lock.unlock();
        }
    }

    private void testTryLock(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println("线程名" + thread.getName() + "获得了锁");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程名" + thread.getName() + "释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println("我是" + Thread.currentThread().getName() + "有人占着锁，我就不要啦");
        }
    }


    public static void main(String[] args) {
        IntroDemo demo = new IntroDemo();

        //测试lock()
        Thread t1 = new Thread(() -> demo.testLock(Thread.currentThread()));
        Thread t2 = new Thread(() -> demo.testLock(Thread.currentThread()));

        //测试tryLock()
//        Thread t1 = new Thread(() -> demo.testTryLock(Thread.currentThread()));
//        Thread t2 = new Thread(() -> demo.testTryLock(Thread.currentThread()));

        t1.start();
        t2.start();
    }
}
