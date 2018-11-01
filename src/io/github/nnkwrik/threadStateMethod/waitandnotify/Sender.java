package io.github.nnkwrik.threadStateMethod.waitandnotify;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author nnkwrik
 * @date 18/10/31 21:04
 */
public class Sender implements Runnable {

    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String packets[] = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };
        for (String packet : packets) {
            data.send(packet);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

    }
}
