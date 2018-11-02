package io.github.nnkwrik.atomicVolatile.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

/**
 * @author nnkwrik
 * @date 18/11/02 12:11
 */
public class LongAccumulatorDemo {

    public static void main(String[] args) throws InterruptedException {
        testAccumulate();   //2086901
    }

    private static void testAccumulate() throws InterruptedException {
        LongBinaryOperator op = (x, y) -> 2 * x + y;
        LongAccumulator accumulator = new LongAccumulator(op,1L);

        Runnable accumulate = () -> {
            IntStream.range(0,10).forEach(i -> accumulator.accumulate(i));
        };
        new Thread(accumulate).start();
        new Thread(accumulate).start();
        TimeUnit.SECONDS.sleep(2);

        System.out.println(accumulator.get());  //输出2086901
    }

}
