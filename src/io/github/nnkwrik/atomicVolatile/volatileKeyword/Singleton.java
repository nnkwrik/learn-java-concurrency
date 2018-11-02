package io.github.nnkwrik.atomicVolatile.volatileKeyword;

/**
 * @author nnkwrik
 * @date 18/11/02 13:29
 */
public class Singleton {
    private volatile static Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
