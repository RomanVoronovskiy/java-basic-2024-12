package ru.otus.java.basic.lesson30.wait_notify;

public class WaitNotifySimpleApp {
    private static class Counter {
        private int value;

        public void inc() {
            value++;
            System.out.println("Counter value after increment: " +
                    value);
        }

        public void dec() {
            value--;
            System.out.println("Counter value after decrement: " +
                    value);
        }
    }

    private final Object mon = new Object();
    private Counter counter = new Counter();

    public static void main(String[] args) {
        WaitNotifySimpleApp waitNotifyApp = new WaitNotifySimpleApp();
        new Thread(() -> {
            waitNotifyApp.toOne();
        }).start();
        new Thread(() -> {
            waitNotifyApp.toZero();
        }).start();
    }

//    public static void main(String[] args) {
//        Counter counter1 = new Counter();
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                counter1.inc();
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                counter1.dec();
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//    }

    public void toOne() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (counter.value != 0) {
                        mon.wait();
                    }
                    counter.inc();
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void toZero() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (counter.value != 1) {
                        mon.wait();
                    }
                    counter.dec();
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

