package io.github.nnkwrik.synchronizedKeyword.chapter2;

import io.github.nnkwrik.synchronizedKeyword.SynchronizedDemo;

/**
 * @author nnkwrik
 * @date 18/11/01 15:52
 * 不同锁之间访问非阻塞
 */
public class Test5 {
    public static void main(String[] args) {
        SynchronizedDemo synDemo = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> synDemo.chunkMethod());   //同步块，锁是一个object
        Thread thread2 = new Thread(() -> synDemo.chunkMethod3());  //同步块，锁是this
        Thread thread3 = new Thread(() -> synDemo.staticMethod());  //静态同步方法,(隐视锁是SynchronizedDemo.class)
        Thread thread4 = new Thread(() -> synDemo.staticMethod2()); //静态方法 + 同步块,锁是SynchronizedDemo.class

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
