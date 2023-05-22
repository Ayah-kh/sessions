package Part12;

import java.util.concurrent.CountDownLatch;

public class SimpleCounter {
    private int counter;

    public synchronized void inc(){
        counter++;
    }

    public synchronized void dec(){
        counter--;
    }

    public synchronized void incAndDec(){
        counter++;
        counter--;
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleCounter simpleCounter=new SimpleCounter();
        int numberOfThreads=1000;
        int numberOfIteration=1000;
        CountDownLatch downLatch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i <numberOfThreads ; i++) {
            new Thread(()-> {
                for (int i1 = 0; i1 < numberOfIteration; i1++) {

//                    simpleCounter.inc();
//                    simpleCounter.dec();

                    simpleCounter.incAndDec();

                    if (simpleCounter.counter!=0){
                        System.out.printf("Not Expexted value %d \n",simpleCounter.counter);
                    }
                }
                downLatch.countDown();
            }).start();
        }
        downLatch.await();
        System.out.println("simpleCounter.counter = " + simpleCounter.counter);
    }
}
