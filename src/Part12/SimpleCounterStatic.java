package Part12;

import java.util.concurrent.CountDownLatch;

public class SimpleCounterStatic {
    private static int counter;

    public static void main(String[] args) throws InterruptedException {
        SimpleCounterStatic simpleCounterStatic = new SimpleCounterStatic();
        SimpleCounterStatic simpleCounterStatic2 = new SimpleCounterStatic();
        int numberOfThreads = 1000;
        int numberOfIteration = 1000;
        CountDownLatch downLatch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                for (int j = 0; j < numberOfIteration; j++) {
                    synchronized (simpleCounterStatic) {
                        simpleCounterStatic.inc();
                        simpleCounterStatic2.inc();
                    }
                }
                downLatch.countDown();
            }).start();
        }
        downLatch.await();
        System.out.println("simpleCounter.counter = " + SimpleCounterStatic.counter);
    }

    public void inc() {
        counter++;
    }

    public synchronized void dec() {
        counter--;
    }


}

