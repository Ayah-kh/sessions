package Part12;

import java.util.concurrent.CountDownLatch;

public class SimpleCounter2 {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        SimpleCounter2 simpleCounter = new SimpleCounter2();
        int numberOfThreads = 1000;
        int numberOfIteration = 1000;
        CountDownLatch downLatch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                for (int j = 0; j < numberOfIteration; j++) {

                    simpleCounter.inc();
                    simpleCounter.dec();

//                    simpleCounter.incAndDec();

                    if (simpleCounter.counter != 0) {
                        System.out.printf("Not Expexted value %d \n", simpleCounter.counter);
                    }
                }
                downLatch.countDown();
            }).start();
        }
        downLatch.await();
        System.out.println("simpleCounter.counter = " + simpleCounter.counter);
    }

    public void inc() {
        counter++;
    }

    public void dec() {
        counter--;
    }

    public void incAndDec() {
        counter++;
        counter--;
    }
}
