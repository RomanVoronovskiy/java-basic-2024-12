package ru.otus.java.basic.lesson30.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceApp {
    public static void main(String[] args) {
        ExecutorService serv = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 160; i++) {
            String w = "#" + i;
            serv.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " - " + w + "-start");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " - " + w + "-end");
                }
            });
        }
        serv.shutdownNow();
        serv.shutdown();
    }
}
