package io.github.nnkwrik.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author nnkwrik
 * @date 18/11/01 18:37
 */
public class StampedLockDemo2 {
    public static void main(String[] args) throws InterruptedException {
        StampedLock lock = new StampedLock();

        Runnable optimisticRead = () ->{
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("乐观锁是否有效  : "+ lock.validate(stamp));
                TimeUnit.SECONDS.sleep(1);
                System.out.println("乐观锁是否有效  : "+ lock.validate(stamp));
                TimeUnit.SECONDS.sleep(2);
                System.out.println("乐观锁是否有效  : "+ lock.validate(stamp));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.tryUnlockRead();
            }
        };

        Runnable write = () -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("获取写锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(stamp);
                System.out.println("写完了");
            }
        };

        new Thread(optimisticRead).start();
        new Thread(write).start();
    }
}
