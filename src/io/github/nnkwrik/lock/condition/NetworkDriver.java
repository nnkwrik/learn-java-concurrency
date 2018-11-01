package io.github.nnkwrik.lock.condition;

/**
 * @author nnkwrik
 * @date 18/10/31 21:13
 */
public class NetworkDriver {

    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}
