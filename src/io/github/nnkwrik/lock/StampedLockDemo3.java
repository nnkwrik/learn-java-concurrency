package io.github.nnkwrik.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author nnkwrik
 * @date 18/11/01 18:54
 */
public class StampedLockDemo3 {

    private static int count = 0;

    public static void main(String[] args) {
        StampedLock lock = new StampedLock();

        Runnable runnable = () -> {
            long stamp = lock.readLock();   //先设为读锁
            try {
                if (count == 0) {
                    stamp = lock.tryConvertToWriteLock(stamp);  //试图转为写锁
                    if (stamp == 0L) {
                        System.out.println("转换写锁失败");
                        stamp = lock.writeLock();   //阻塞当前线程，直到有可用的写锁
                    }
                    count = 23;
                }
                System.out.println(count);

            } finally {
                lock.unlock(stamp);
            }
        };

        new Thread(runnable).start();
    }
}
