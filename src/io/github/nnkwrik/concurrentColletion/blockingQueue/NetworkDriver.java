package io.github.nnkwrik.concurrentColletion.blockingQueue;

import io.github.nnkwrik.concurrentColletion.blockingQueue.delayQueue.DNetworkDriver;
import io.github.nnkwrik.concurrentColletion.blockingQueue.transferQueue.TNetworkDriver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.*;

/**
 * @author nnkwrik
 * @date 18/10/31 21:13
 */
public class NetworkDriver {


    public static void main(String[] args) throws InterruptedException {
//        testArrayBlockingQueue();
//        testLinkedBlockingQueue();
//        testPriorityBlockingQueue();
        testSynchronousQueue();
//        DNetworkDriver.testDelayQueue();
//        TNetworkDriver.testLinkedTransferQueue();
    }

    public static void testArrayBlockingQueue() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(100, true);
        Data data = new Data(blockingQueue);
        Thread sender = new Thread(new Sender(data), "Sender Thread");
        Thread receiver = new Thread(new Receiver(data), "Receiver Thread");

        sender.start();
        receiver.start();
    }

    public static void testLinkedBlockingQueue() {
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
        Data data = new Data(blockingQueue);
        Thread sender = new Thread(new Sender(data), "Sender Thread");
        Thread receiver = new Thread(new Receiver(data), "Receiver Thread");

        sender.start();
        receiver.start();
    }

    public static void testPriorityBlockingQueue() throws InterruptedException {
        //按字母排序，输出字符串倒序后的结果
        BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>(100, Comparator.reverseOrder());
        Data data = new Data(blockingQueue);
        Thread sender = new Thread(new Sender(data), "Sender Thread");
        Thread receiver = new Thread(new Receiver(data), "Receiver Thread");

        sender.start();
        sender.join();  //等发送方全部发送完成
        receiver.start();
    }

    public static void testSynchronousQueue() throws InterruptedException {
        //只会取到最后被放入的元素
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        int senderNum = 3;
        Data data = new Data(blockingQueue);
        for (int i = 0; i < senderNum; i++) {
            Thread sender = new Thread(new Sender(data), "Sender Thread" + i);
            sender.start();

        }
        Thread receiver = new Thread(new Receiver(data, senderNum), "Receiver Thread");

        receiver.start();
    }


}
