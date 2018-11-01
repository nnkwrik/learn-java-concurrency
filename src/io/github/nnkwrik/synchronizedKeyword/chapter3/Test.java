package io.github.nnkwrik.synchronizedKeyword.chapter3;

import io.github.nnkwrik.synchronizedKeyword.SynchronizedDemo;

/**
 * @author nnkwrik
 * @date 18/11/01 15:52
 * Synchronized的可重入性
 */
public class Test {
    public static void main(String[] args) {
        SynchronizedDemo synDemo = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> {
            synDemo.synMethod();
            synDemo.synMethod2();
        });

        Thread thread2 = new Thread(() -> {
            synDemo.synMethod2();
            synDemo.synMethod();
        });

        thread1.start();
        thread2.start();
    }
}
