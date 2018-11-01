package io.github.nnkwrik.synchronizedKeyword.chapter2;

import io.github.nnkwrik.synchronizedKeyword.SynchronizedDemo;

/**
 * @author nnkwrik
 * @date 18/11/01 15:52
 * 同一个锁的同步代码块同一时刻只能被一个线程访问
 */
public class Test3 {
    public static void main(String[] args) {
        SynchronizedDemo synDemo = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> {
            synDemo.chunkMethod();
            synDemo.chunkMethod2();

        });
        Thread thread2 = new Thread(() -> {
            synDemo.chunkMethod();
            synDemo.chunkMethod2();
        });

        thread1.start();
        thread2.start();

    }
}
