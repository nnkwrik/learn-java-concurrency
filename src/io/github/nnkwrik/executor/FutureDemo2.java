package io.github.nnkwrik.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author nnkwrik
 * @date 18/11/04 15:13
 */
public class FutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        testInvokeAll();
        testInvokeAny();
    }

    private static void testInvokeAll() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");
        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
        executor.shutdown();
    }

    private static Callable<String> callable(String result, long sleepSeconds){
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    private static void testInvokeAny() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                callable("task1",2),
                callable("task2",1),
                callable("task3",3));
        String result = executor.invokeAny(callables);
        System.out.println(result);

        executor.shutdown();
    }

}
