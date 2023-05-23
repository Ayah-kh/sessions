package Part12;

import java.util.concurrent.CountDownLatch;

public class JoinApplication {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch downLatch = new CountDownLatch(1);
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Done");
            downLatch.countDown();
        });

        thread.start();

        System.out.println("Main Thread");

        System.out.println("Do another operation");

//        thread.join();
        downLatch.await();
        System.out.println("Thread joined main thread");

        //

    }
}
