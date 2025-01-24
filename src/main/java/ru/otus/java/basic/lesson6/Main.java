package ru.otus.java.basic.lesson6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        for (int i = 0; i < 3; i++) {
            String item = scanner.next();
            inventory.add(item);
        }
        System.out.println("inventory.isEmpty() = " + inventory.isEmpty());
        inventory.printAllItems();
    }

    private static void gameMagicField() {
        Scanner scanner = new Scanner(System.in);
        String[] fruits = {"apple", "pineapple", "melon",
                "lemon", "peach", "strawberry", "orange", "watermelon"};
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(fruits.length);
        String wordToGuess = fruits[randomIndex];
        System.out.println("Игра Поле чудес началась!");
        boolean win = false;
        char[] result = new char[wordToGuess.length()];
        Arrays.fill(result, '*');
        while (!win) {
            System.out.println("Введи букву!");
            char latter = scanner.next().charAt(0);
            char[] toGuess = wordToGuess.toCharArray();
            System.out.println("Слово: ");
            for (int i = 0; i < toGuess.length; i++) {
                if (toGuess[i] == latter) {
                    result[i] = latter;
                }
            }

            boolean flag = true;
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (result[i] == '*') {
                    flag = false;
                }
            }
            System.out.println();
            if (flag) {
                win = true;
                System.out.println("Вы победили");
            }
        }
    }

    private static void gameToGuessWorld() {
        Scanner scanner = new Scanner(System.in);
        String[] fruits = {"apple", "pineapple", "melon",
                "lemon", "peach", "strawberry", "orange", "watermelon"};
        int randomIndex = (int) (Math.random() * fruits.length);
        String wordToGuess = fruits[randomIndex];
        System.out.println("Игра угадайте фрукт началась!");
        boolean win = false;
        while (!win) {
            String inputFruit = scanner.next();
            if (wordToGuess.equals(inputFruit)) {
                System.out.println("Вы победили!");
                win = false;
            } else {
                char[] toGuess = wordToGuess.toCharArray();
                char[] input = inputFruit.toCharArray();
                for (int i = 0; i < toGuess.length && i < input.length; i++) {
                    if (toGuess[i] == input[i]) {
                        System.out.print(input[i]);
                    } else {
                        System.out.print("*");
                    }
                }
                int minLength = Math.min(wordToGuess.length(), inputFruit.length());
                for (int i = 0; i < (10 - minLength); i++) {
                    System.out.println("*");
                }
                System.out.println();
                System.out.println("Вы не угадали, попровуйте ещё раз!");
            }
        }
    }

    /**
     * @param array входной массив
     * @apiNote описание расширенное
     */
    private static void getMaxFromArray(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("max = " + max);
    }

    private static void getMinFromArray(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("min = " + min);
    }
}