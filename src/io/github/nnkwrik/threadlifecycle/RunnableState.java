package io.github.nnkwrik.threadlifecycle;

/**
 * @author nnkwrik
 * @date 18/10/30 22:16
 */
public class RunnableState implements Runnable{
    @Override
    public void run() {
        System.out.println("running");
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new RunnableState();
        Thread thread = new Thread(runnable);
        thread.start();

//        Thread.sleep(100);
        System.out.println(thread.getState());
    }
}

//输出结果可能是RUNNABLE ，running
//也可能是running ，RUNNABLE
//由于是多核的CPU所以main线程和新建的线程的两个线程都会被同时调度，
//尽管如此执行速度还是存在随机性的。
//另外，当main中加入Thread.sleep(100);后，输出变为running ，TERMINATED
