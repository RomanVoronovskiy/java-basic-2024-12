package ru.otus.java.basic.lesson18;


import ru.otus.java.basic.lesson18.util.Measure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class LinkedListVsArrayList {
    static int SIZE = 100_00000;
    static Random rnd = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = getArrayList();
        LinkedList<Integer> linkedList = integerLinkedList();

        Measure.stamp();
        insert(arrayList);
        Measure.print();

        Measure.stamp();
        insert(linkedList);
        Measure.print();

//        Measure.stamp();
//        search(arrayList);
//        Measure.print();
//
//        Measure.stamp();
//        search(linkedList);
//        Measure.print();
    }

    private static ArrayList<Integer> getArrayList() {
        ArrayList<Integer> ar = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            ar.add(rnd.nextInt(10));
        }
        return ar;
    }

    private static LinkedList<Integer> integerLinkedList() {
        LinkedList<Integer> ar = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            ar.add(rnd.nextInt(10));
        }
        return ar;
    }

    private static void search(List<Integer> list) {
        for (int i = 0; i < SIZE; i++) {
            list.get(i);
        }
    }

    static void insert(List<Integer> list) {
        for (int i = 0; i < SIZE; i++) {
//            list.add(i);
            list.add(list.size() / 2, i);
//            list.add(0, i);
        }
    }
}
