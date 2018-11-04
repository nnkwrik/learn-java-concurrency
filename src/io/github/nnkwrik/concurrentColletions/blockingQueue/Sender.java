package io.github.nnkwrik.concurrentColletions.blockingQueue;

/**
 * @author nnkwrik
 * @date 18/10/31 21:04
 */
public class Sender implements Runnable {

    protected Data data;

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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

    }
}
