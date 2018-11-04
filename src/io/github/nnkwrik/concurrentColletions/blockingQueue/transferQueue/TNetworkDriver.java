package io.github.nnkwrik.concurrentColletions.blockingQueue.transferQueue;

import io.github.nnkwrik.concurrentColletions.blockingQueue.Receiver;
import io.github.nnkwrik.concurrentColletions.blockingQueue.Sender;

import java.util.concurrent.*;

/**
 * @author nnkwrik
 * @date 18/10/31 21:13
 */
public class TNetworkDriver {


    public static void testLinkedTransferQueue() throws InterruptedException {
        //生产者会一直阻塞直到自己放入的元素被取走
        TransferQueue<String> blockingQueue = new LinkedTransferQueue<>();

        TData data = new TData(blockingQueue);
        for (int i = 0; i < 3; i++) {
            Thread sender = new Thread(new Sender(data), "Sender Thread" + i);
            sender.start();

        }
        Thread receiver = new Thread(new Receiver(data), "Receiver Thread");
        receiver.start();
    }


}
