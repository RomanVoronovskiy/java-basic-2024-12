package ru.otus.java.basic.lesson30.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AnotherExecutorServiceExampleApp {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "Java";
            }
        });
        Future<String> future2 = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "2 example";
            }
        });

        try {
            System.out.println(future2.get());
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("END");
        service.shutdown();
    }
}
