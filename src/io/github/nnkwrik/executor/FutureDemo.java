package io.github.nnkwrik.executor;

import java.util.concurrent.*;

/**
 * @author nnkwrik
 * @date 18/11/04 15:13
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        testFuture();
//        testShutDownCallable();
//        testTimeLimitFuture();
    }

    private static void testFuture() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        };
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());
        Integer result = future.get();
        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);

        executor.shutdown();
    }

    private static void testShutDownCallable() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        });

        executor.shutdownNow();
        future.get();
    }

    private static void testTimeLimitFuture() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        });


        future.get(500, TimeUnit.MILLISECONDS);
    }

}
