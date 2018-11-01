package io.github.nnkwrik.synchronizedKeyword.chapter4;

import io.github.nnkwrik.synchronizedKeyword.SynchronizedDemo;

/**
 * @author nnkwrik
 * @date 18/11/01 15:52
 * Synchronized与String锁
 */
public class Test {
    public static void main(String[] args) {
        SynchronizedDemo synDemo = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> synDemo.stringMethod("string"));
        Thread thread2 = new Thread(() -> synDemo.stringMethod("string"));
        thread1.start();
        thread2.start();
    }
}
