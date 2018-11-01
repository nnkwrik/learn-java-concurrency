package io.github.nnkwrik.synchronizedKeyword.chapter5;

/**
 * @author nnkwrik
 * @date 18/11/01 16:40
 */
public class SynchronizedDemo {
    static Integer i = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
                for (int j = 0; j < 10000; j++) {
                    synchronized (i){
                        i++;
                    }
                }
            };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
