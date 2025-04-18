package ru.otus.java.basic.lesson18;


import ru.otus.java.basic.lesson18.util.Measure;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class HashMapVsTreeMap {
    static int SIZE = 100000;

    public static void main(String[] args) {
        NavigableMap<Integer, Integer> treeMap = new TreeMap<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        System.out.println("fill ==========");
        Measure.stamp();
        fill(treeMap);
        Measure.print();

        Measure.stamp();
        fill(hashMap);
        Measure.print();
        System.out.println("search ==========");

        Measure.stamp();
        search(treeMap);
        Measure.print();

        Measure.stamp();
        search(hashMap);
        Measure.print();

        System.out.println(treeMap.subMap(23, 44));
    }

    public static void fill(Map<Integer, Integer> map) {
        for (int i = 0; i < SIZE; i++) {
            map.put(i, i);
        }
    }

    public static void search(Map<Integer, Integer> map) {
        for (int i = 0; i < SIZE; i++) {
            map.get(i);
        }
    }
}
