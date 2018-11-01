package io.github.nnkwrik.threadStateMethod.join;

/**
 * @author nnkwrik
 * @date 18/11/01 8:40
 */
public class TestJoin implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestJoin());
        long start = System.currentTimeMillis();
        t.start();
        Thread.sleep(1000);	//为了让线程调度器能调度到t
        t.join(2000);
        System.out.println("t.io.github.nnkwrik.threadStateMethod.join()调用结束，耗时(ms)：" + (System.currentTimeMillis() - start));
        System.out.println("Main 结束了");
    }

    @Override
    public void run() {
//        synchronized (Thread.currentThread()) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sleeping" + i);
            }
            System.out.println("TestJoin 结束了");
//        }
    }
}
