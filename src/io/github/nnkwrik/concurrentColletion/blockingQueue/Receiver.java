package io.github.nnkwrik.concurrentColletion.blockingQueue;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author nnkwrik
 * @date 18/10/31 21:09
 */
public class Receiver implements Runnable {

    private Data load;
    private int senderNum = 1;

    public Receiver(Data load, int consumerNum) {
        this.load = load;
        this.senderNum = consumerNum;
    }

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        while (senderNum >= 0) {

            String receivedMessage = load.receive();
            if ("End".equals(receivedMessage)) senderNum--;

            System.out.println("=======> " + receivedMessage);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
    }
}
