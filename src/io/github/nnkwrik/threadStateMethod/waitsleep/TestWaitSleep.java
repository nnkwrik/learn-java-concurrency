package io.github.nnkwrik.threadStateMethod.waitsleep;

import java.time.LocalTime;

/**
 * @author nnkwrik
 * @date 18/10/31 21:27
 */
public class TestWaitSleep {

    public static void main(String[] args) throws InterruptedException {

        //测试wait会释放锁
//        new Thread(new WaitTread()).start();
//        Thread.sleep(1000);
//        new Thread(new SleepThread()).start();

        //测试sleep不会释放锁
        new Thread(new SleepThread()).start();
        Thread.sleep(1000);
        new Thread(new WaitTread()).start();

    }
}

class WaitTread implements Runnable {

    @Override
    public void run() {
        synchronized (TestWaitSleep.class) {
            System.out.println("进入WaitTread 当前时间 ： " + LocalTime.now());
            //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
            try {
                TestWaitSleep.class.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("WaitTread结束了 当前时间 ： " + LocalTime.now());
        }
    }
}

class SleepThread implements Runnable {

    @Override
    public void run() {
        synchronized (TestWaitSleep.class) {
            System.out.println("进入SleepThread 当前时间 ： " + LocalTime.now());


            //在调用sleep()方法的过程中，线程不会释放对象锁。
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("SleepThread结束了 当前时间 ： " + LocalTime.now());
        }
    }
}
