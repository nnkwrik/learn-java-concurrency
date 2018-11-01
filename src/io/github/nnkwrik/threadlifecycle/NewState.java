package io.github.nnkwrik.threadlifecycle;

/**
 * @author nnkwrik
 * @date 18/10/30 22:16
 */
public class NewState implements Runnable{
    @Override
    public void run() {
        System.out.println("running");  //不会输出
    }

    public static void main(String[] args) {
        Runnable runnable = new NewState();
        Thread thread = new Thread(runnable);
        System.out.println(thread.getState());
    }
}
