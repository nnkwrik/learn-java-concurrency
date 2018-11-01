package io.github.nnkwrik.synchronizedKeyword;

/**
 * @author nnkwrik
 * @date 18/11/01 15:49
 */
public class SynchronizedDemo {
    public static synchronized void staticMethod(){
        System.out.println(Thread.currentThread().getName() + "访问了静态同步方法staticMethod");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束访问静态同步方法staticMethod");
    }
    public static void staticMethod2(){
        System.out.println(Thread.currentThread().getName() + "访问了静态同步方法staticMethod2");
        synchronized (SynchronizedDemo.class){
            System.out.println(Thread.currentThread().getName() + "在staticMethod2方法中获取了SynchronizedDemo.class");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void synMethod(){
        System.out.println(Thread.currentThread().getName() + "访问了同步方法synMethod");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束访问同步方法synMethod");
    }
    public synchronized void synMethod2(){
        System.out.println(Thread.currentThread().getName() + "访问了同步方法synMethod2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束访问同步方法synMethod2");
    }
    public void method(){
        System.out.println(Thread.currentThread().getName() + "访问了普通方法method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束访问普通方法method");
    }
    private Object lock = new Object();
    public void chunkMethod(){
        System.out.println(Thread.currentThread().getName() + "访问了chunkMethod方法");
        synchronized (lock){
            System.out.println(Thread.currentThread().getName() + "在chunkMethod方法中获取了lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void chunkMethod2(){
        System.out.println(Thread.currentThread().getName() + "访问了chunkMethod2方法");
        synchronized (lock){
            System.out.println(Thread.currentThread().getName() + "在chunkMethod2方法中获取了lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void chunkMethod3(){
        System.out.println(Thread.currentThread().getName() + "访问了chunkMethod3方法");
        //同步代码块
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + "在chunkMethod3方法中获取了this");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stringMethod(String lock){
        synchronized (lock){
            while (true){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
