package io.github.nnkwrik.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author nnkwrik
 * @date 18/11/01 18:22
 */
public class StampedLockDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        StampedLock lock = new StampedLock();


        Runnable write = () -> {
            long stamp = lock.writeLock();
            try {
                TimeUnit.SECONDS.sleep(1);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }
        };

        Runnable read = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("foo"));
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }
        };

        //开启一个写线程和两个读线程
        new Thread(write).start();
        new Thread(read).start();
        new Thread(read).start();

    }
}
