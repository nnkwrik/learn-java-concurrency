package io.github.nnkwrik.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nnkwrik
 * @date 18/10/31 20:51
 */
public class Data {
    private String packet;
    private final Lock lock = new ReentrantLock();
    private boolean transfer = true;

    private final Condition receiveCondition = lock.newCondition();
    private final Condition senderCondition = lock.newCondition();

    public String receive() {
        lock.lock();
        try {
            while (transfer) {
                receiveCondition.await();
            }
            transfer = true;
            senderCondition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            return packet;
        }

    }

    public void send(String packet) {
        lock.lock();
        try {
            while (!transfer) {
                senderCondition.await();
            }
            transfer = false;
            this.packet = packet;
            receiveCondition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
