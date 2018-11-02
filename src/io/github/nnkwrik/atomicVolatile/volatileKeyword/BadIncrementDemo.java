package io.github.nnkwrik.atomicVolatile.volatileKeyword;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author nnkwrik
 * @date 18/11/02 13:05
 */
public class BadIncrementDemo {

    public static volatile int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable increment = () -> {
            IntStream.range(0, 10).forEach(i -> {
                cnt++;
            });
        };

        //启动1000个 执行10次cnt++的线程
        IntStream.range(0, 100).forEach(i -> {
            new Thread(increment).start();
        });


        TimeUnit.SECONDS.sleep(1);
        System.out.println(cnt);    //可能输出998
    }
}
