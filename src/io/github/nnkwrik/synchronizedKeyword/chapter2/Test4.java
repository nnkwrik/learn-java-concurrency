package io.github.nnkwrik.synchronizedKeyword.chapter2;

import io.github.nnkwrik.synchronizedKeyword.SynchronizedDemo;

/**
 * @author nnkwrik
 * @date 18/11/01 15:52
 * 线程间同时访问同一个锁的多个同步代码的执行顺序不定
 */
public class Test4 {
    public static void main(String[] args) {
        SynchronizedDemo synDemo = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> {
            synDemo.chunkMethod();
            synDemo.chunkMethod2();

        });
        Thread thread2 = new Thread(() -> {
            synDemo.chunkMethod2();
            synDemo.chunkMethod();
        });

        thread1.start();
        thread2.start();

    }
}
