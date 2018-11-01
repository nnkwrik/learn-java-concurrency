package io.github.nnkwrik.threadlifecycle;

/**
 * @author nnkwrik
 * @date 18/10/30 22:57
 */
public class BlockedState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoThread());
        Thread t2 = new Thread(new DemoThread());

        t1.start();
        t2.start();

        Thread.sleep(1000);

        System.out.println(t2.getState());  //BLOCKED
        System.exit(0);


    }

}

class DemoThread implements Runnable{

    @Override
    public void run() {
        commonResource();
    }

    public static synchronized void commonResource(){
        while (true){
            //写一个死循环
            //此时t1不会返回，t2因为没锁所以进不来，因此t2处于BLOCKED状态
        }
    }
}
