package io.github.nnkwrik.concurrentColletions.blockingQueue.transferQueue;

import io.github.nnkwrik.concurrentColletions.blockingQueue.Data;

import java.util.concurrent.TransferQueue;

/**
 * @author nnkwrik
 * @date 18/10/31 20:51
 */
public class TData extends Data {

    private TransferQueue<String> transferQueue;

    public TData(TransferQueue transferQueue) {
        super(null);
        this.transferQueue = transferQueue;
    }

    @Override
    public String receive() {

        try {
            String packet = transferQueue.take();
            System.out.println(Thread.currentThread().getName() + " receive: " + packet);
            return packet;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        return null;

    }
    @Override
    public void send(String packet) {

        try {
            System.out.println(Thread.currentThread().getName() + " send: " + packet);
//            transferQueue.put(packet);
            transferQueue.transfer(packet + " FROM " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }
}
