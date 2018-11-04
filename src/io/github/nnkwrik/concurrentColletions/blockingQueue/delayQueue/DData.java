package io.github.nnkwrik.concurrentColletions.blockingQueue.delayQueue;

import io.github.nnkwrik.concurrentColletions.blockingQueue.Data;

import java.util.concurrent.DelayQueue;

/**
 * @author nnkwrik
 * @date 18/10/31 20:51
 */
public class DData extends Data {

    private DelayQueue<DelayPacket> delayQueue;

    private final int DELAY = 3000; //3秒发送延迟

    public DData(DelayQueue delayQueue) {
        super(null);
        this.delayQueue = delayQueue;
    }
    @Override
    public String receive() {

        try {
            String packet = delayQueue.take().toString();
            System.out.println(Thread.currentThread().getName() + " receive: " + packet);
            return packet+ " <======= FROM " + Thread.currentThread().getName();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        return null;

    }
    @Override
    public void send(String packet) {
        System.out.println(Thread.currentThread().getName() + " send: " + packet);
        DelayPacket delayPacket = new DelayPacket(packet, DELAY);
        delayQueue.put(delayPacket);
    }
}
