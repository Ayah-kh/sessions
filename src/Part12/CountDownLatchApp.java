package Part12;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchApp {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startLatch = new CountDownLatch(1);

        int numberOfThreads = 3;
        CountDownLatch endLatch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                System.out.println("Thread started");

                try {
                    startLatch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Now do Thread operation");
                atomicInteger.incrementAndGet();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                endLatch.countDown();
            }).start();
        }
        System.out.println("Wait 4 seconds");
        Thread.sleep(6000);
        startLatch.countDown();

        System.out.println("Wait all thread to complete ");

        endLatch.await();

    }
}
