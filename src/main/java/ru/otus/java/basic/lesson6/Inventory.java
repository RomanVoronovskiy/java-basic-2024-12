package ru.otus.java.basic.lesson6;

public class Inventory {
    public String[] items = new String[5];

    public void add(String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                System.out.println("Мы добавили предмет: "
                        + item + " в рюкзак!");
                return;
            }
        }
        System.out.println("Места нет!");
    }

    public boolean isEmpty() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                return false;
            }
        }
        return true;
    }

    public void printAllItems() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println(items[i]);
            }
        }
    }

}
