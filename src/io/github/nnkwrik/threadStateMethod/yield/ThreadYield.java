package io.github.nnkwrik.threadStateMethod.yield;

/**
 * @author nnkwrik
 * @date 18/11/01 9:36
 */
public class ThreadYield {
    public static void main(String[] args) {
        Runnable r = () -> {
            int counter = 0;
            while (counter < 2) {
                System.out.println(Thread.currentThread().getName());
                counter++;
                Thread.yield();
            }
        };

        new Thread(r).start();
        new Thread(r).start();
    }
}
