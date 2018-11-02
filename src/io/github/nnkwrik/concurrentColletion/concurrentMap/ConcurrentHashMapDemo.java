package io.github.nnkwrik.concurrentColletion.concurrentMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * @author nnkwrik
 * @date 18/11/02 20:48
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
//        testForkJoinPool();
        testForeach();
//        testSearch();
//        testSearch2();
//        testReduce();
    }

    public static void testForkJoinPool() {
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
    }

    public static void testForeach() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.forEach(1, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n",
                key, value, Thread.currentThread().getName()));

    }

    public static void testSearch() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        String result = map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if ("foo".equals(key)) {
                return value;
            }
            return null;
        });

        System.out.println("Result: " + result);
    }

    public static void testSearch2() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        String result = map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return value;
            }
            return null;
        });

        System.out.println("Result: " + result);
    }

    public static void testReduce() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        String result = map.reduce(1,
                (key, value) -> {
                    System.out.println("Transform: " + Thread.currentThread().getName());
                    return key + "=" + value;
                },
                (s1, s2) -> {
                    System.out.println("Reduce: " + Thread.currentThread().getName());
                    return s1 + ", " + s2;
                }
        );

        System.out.println(result);
    }


}
