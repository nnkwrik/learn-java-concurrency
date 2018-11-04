package io.github.nnkwrik.concurrentColletions.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author nnkwrik
 * @date 18/10/31 20:51
 */
public class Data {

    private BlockingQueue<String> queue;

    public Data(BlockingQueue queue) {
        this.queue = queue;
    }

    public String receive() {

        try {
            String packet = queue.take();
            System.out.println(Thread.currentThread().getName() + " receive: " + packet);
            return packet+ " <======= FROM " + Thread.currentThread().getName();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        return null;

    }

    public void send(String packet) {

        try {
            System.out.println(Thread.currentThread().getName() + " send: " + packet);
            queue.put(packet);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
