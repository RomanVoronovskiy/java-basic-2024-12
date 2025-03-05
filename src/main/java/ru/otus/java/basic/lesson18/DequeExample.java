package ru.otus.java.basic.lesson18;

import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        //TODO: FIFO   first in first out
//        Deque<Integer> deque = new LinkedList<>();
//        deque.add(1);
//        deque.add(2);
//        deque.add(3);
//
//        while (!deque.isEmpty()){
//            System.out.println(deque.poll());
//        }
        // TODO: LIFO  last in first out
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);

        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }
}
