package io.github.nnkwrik.concurrentColletion.blockingQueue.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author nnkwrik
 * @date 18/11/04 9:48
 */
public class DelayPacket implements Delayed {

    private String data;
    private long startTime;


    DelayPacket(String data, long delayInMilliseconds) {
        this.data = data;
        this.startTime = System.currentTimeMillis() + delayInMilliseconds;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) ( this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "{" + "data='" + data + '\'' + ", startTime=" + startTime + '}';
    }

}
