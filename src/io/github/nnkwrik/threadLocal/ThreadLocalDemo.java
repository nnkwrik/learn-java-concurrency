package io.github.nnkwrik.threadLocal;


import java.time.Instant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * @author nnkwrik
 * @date 18/11/04 19:49
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            threadLocal.set(Instant.now().toString());
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " ==> " + threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executorService.submit(task1);
            TimeUnit.SECONDS.sleep(1);
        }

    }

}
