package io.github.nnkwrik.concurrentColletions.concurrentMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author nnkwrik
 * @date 18/11/02 20:48
 */
public class ConcurrentMapDemo {

    public static void main(String[] args) {
        testForeach();
//        testPutIfAbsent();
//        testGetOrDefault();
//        testReplaceAll();
//        testCompute();
//        testComputeIfAbsent();
//        testComputeIfPresent();
//        testMarge();
    }


    public static void testForeach() {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));
    }

    public static void testPutIfAbsent() {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        String value = map.putIfAbsent("c3", "p1");
        System.out.println(value);          //输出p0
        System.out.println(map.get("c3"));  //返回的仍是原来的p0

        String value2 = map.putIfAbsent("c4", "p1");
        System.out.println(value2);         //输出null
        System.out.println(map.get("c4"));  //返回新值p1
    }

    public static void testGetOrDefault() {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        String value = map.getOrDefault("hi", "there");
        System.out.println(value);
    }

    public static void testReplaceAll() {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.replaceAll((key, value) -> "r2".equals(key) ? "d3" : value);
        System.out.println(map.get("r2"));
    }

    public static void testCompute() {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.compute("foo", (key, value) -> key + value);
        System.out.println(map.get("foo"));
    }

    public static void testComputeIfAbsent() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.computeIfAbsent("no", (key) -> "--" + key);
        System.out.println(map.get("no"));  //--no
    }

    public static void testComputeIfPresent() {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.computeIfPresent("c3", (key, value) -> key + ":" + value);
        System.out.println(map.get("c3"));  //c3:p0
    }

    public static void testMarge() {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.merge("foo",    //键
                "newVal",  //想要并入的新值 “newVal”
                (oldVal, newVal) -> newVal + " was " + oldVal);//oldVal是原来的值“bar”,newVal是新值 “newVal”
        System.out.println(map.get("foo")); //new was bar
    }

}
