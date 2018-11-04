package io.github.nnkwrik.concurrentColletions.copyOnWriteArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author nnkwrik
 * @date 18/11/04 12:09
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        testInsert();
//        testRemove();
    }

    public static void testInsert(){
        CopyOnWriteArrayList<Integer> numbers
                = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4));
        Iterator<Integer> preIt = numbers.iterator();
        numbers.add(9);
        Iterator<Integer> newIt = numbers.iterator();

        preIt.forEachRemaining(System.out::print);
        System.out.println();
        newIt.forEachRemaining(System.out::print);
    }

    public static void testRemove(){
        CopyOnWriteArrayList<Integer> numbers
                = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4));
        Iterator<Integer> it = numbers.iterator();
        try {
        while (it.hasNext())
            it.remove();
        } catch (UnsupportedOperationException e){
            System.out.println("抛出了UnsupportedOperationException");
        }

    }
}
