package io.github.nnkwrik.synchronizedKeyword.chapter2;

import io.github.nnkwrik.synchronizedKeyword.SynchronizedDemo;

/**
 * @author nnkwrik
 * @date 18/11/01 15:52
 * 普通方法与同步方法调用互不关联
 */
public class Test1 {
    public static void main(String[] args) {
        SynchronizedDemo synDemo = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> {
            //调用普通方法
            synDemo.method();
        });
        Thread thread2 = new Thread(() -> {
            //调用同步
            synDemo.synMethod();
        });

        thread1.start();
        thread2.start();

    }
}
