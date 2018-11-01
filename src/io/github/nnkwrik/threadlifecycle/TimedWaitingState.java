package io.github.nnkwrik.threadlifecycle;

/**
 * @author nnkwrik
 * @date 18/10/31 19:16
 */
public class TimedWaitingState {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoThreadTW());
        t1.start();
        Thread.sleep(1000);
        System.out.println(t1.getState());
    }
}

class DemoThreadTW implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
