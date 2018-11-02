package io.github.nnkwrik.atomicVolatile.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author nnkwrik
 * @date 18/11/02 10:45
 */
public class AtomicDemo {
    private static AtomicInteger atomicInt = new AtomicInteger(0);
    private static Integer normalInt = new Integer(0);

    public static void main(String[] args) throws InterruptedException {
        testIncrement();//输出20000
//        testBadIncrement();//可能输出 15371
//        testUpdate();   //输出4000
//        testAccumulate();   //输出4000

    }

    public static void testIncrement() throws InterruptedException {
        atomicInt.set(0);
        Runnable increment = () -> {    //输出20000

            IntStream.range(0, 10000).forEach(i -> {
                atomicInt.incrementAndGet();
            });
        };
        new Thread(increment).start();
        new Thread(increment).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(atomicInt.get());
    }

    public static void testBadIncrement() throws InterruptedException {
        normalInt = 0;
        Runnable badIncrement = () -> { //可能输出 15371

            IntStream.range(0, 10000).forEach(i -> {
                normalInt++;
            });
        };
        new Thread(badIncrement).start();
        new Thread(badIncrement).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(normalInt);
    }

    public static void testUpdate() throws InterruptedException {
        atomicInt.set(0);
        Runnable update = () -> {
            IntStream.range(0, 1000).forEach(i -> {
                atomicInt.updateAndGet(n -> n + 2);
            });
        };
        new Thread(update).start();
        new Thread(update).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(atomicInt.get());    //输出4000
    }

    public static void testAccumulate() throws InterruptedException {
        atomicInt.set(0);
        Runnable accumulate = () -> {
            IntStream.range(0, 1000).forEach(i -> {
                atomicInt.accumulateAndGet(2, (n, m) -> n + m);
//                atomicInt.accumulateAndGet(2, Integer::sum);
            });
        };
        new Thread(accumulate).start();
        new Thread(accumulate).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(atomicInt.get());    //输出4000
    }

}
