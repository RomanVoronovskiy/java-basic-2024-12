package ru.otus.java.basic.lesson18;


import ru.otus.java.basic.lesson18.util.Measure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class SetVsList {
    static int SIZE = 100000;

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        Measure.stamp();
        insert(arrayList);
        Measure.print();

        Measure.stamp();
        insert(hashSet);
        Measure.print();

        Measure.stamp();
        search(arrayList);
        Measure.print();

        Measure.stamp();
        search(hashSet);
        Measure.print();
    }

    static void insert(Collection<Integer> list) {
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    static void search(Collection<Integer> list) {
        for (int i = 0; i < SIZE; i++) {
            list.contains(i);
        }
    }
}
