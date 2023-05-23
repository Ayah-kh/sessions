package Part12;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicApplication {
    private AtomicInteger counter= new AtomicInteger(0);

    private void inc(){
        counter.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {

        AtomicApplication anotherCounter =new AtomicApplication();
        int numberOfThreads=1000;
        int numberOfIteration=1000;
        CountDownLatch downLatch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i <numberOfThreads ; i++) {
            new Thread(()-> {
                for (int j = 0; j < numberOfIteration; j++)
                    anotherCounter.inc();

                downLatch.countDown();
            }).start();
        }
        downLatch.await();
        System.out.println("anotherCounter.counter = " + anotherCounter.counter);

    }
}
