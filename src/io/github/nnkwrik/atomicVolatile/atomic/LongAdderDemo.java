package io.github.nnkwrik.atomicVolatile.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * @author nnkwrik
 * @date 18/11/02 11:56
 */
public class LongAdderDemo {
    private static LongAdder adder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        testIncrement();    //输出20000
    }

    public static void testIncrement() throws InterruptedException {

        Runnable increment = () -> {

            IntStream.range(0, 10000).forEach(i -> {
                adder.add(1);
//                adder.increment();
            });
        };
        new Thread(increment).start();
        new Thread(increment).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(adder.sumThenReset());    //输出20000,并归零
    }

}
