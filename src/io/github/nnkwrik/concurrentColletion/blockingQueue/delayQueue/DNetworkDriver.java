package io.github.nnkwrik.concurrentColletion.blockingQueue.delayQueue;

import io.github.nnkwrik.concurrentColletion.blockingQueue.Receiver;
import io.github.nnkwrik.concurrentColletion.blockingQueue.Sender;
import io.github.nnkwrik.concurrentColletion.blockingQueue.transferQueue.TData;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author nnkwrik
 * @date 18/10/31 21:13
 */
public class DNetworkDriver {


    public static void testDelayQueue() throws InterruptedException {

        DelayQueue<DelayPacket> delayQueue = new DelayQueue<>();

        DData data = new DData(delayQueue);
        Thread sender = new Thread(new Sender(data), "Sender Thread");
        Thread receiver = new Thread(new Receiver(data), "Receiver Thread");

        sender.start();
        receiver.start();   //延迟3秒后收到
    }


}
