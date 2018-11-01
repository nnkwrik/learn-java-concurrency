package io.github.nnkwrik.lock.condition;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author nnkwrik
 * @date 18/10/31 21:09
 */
public class Receiver implements Runnable {

    private Data load;

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        for (String receivedMessage = load.receive();
             !"End".equals(receivedMessage);
             receivedMessage = load.receive()) {

            System.out.println(receivedMessage);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
    }
}
