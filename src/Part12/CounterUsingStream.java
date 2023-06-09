package Part12;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CounterUsingStream {
    private AtomicInteger counter=new AtomicInteger(0);

    private void inc(){
        counter.incrementAndGet();
    }
    public static void main(String[] args) throws InterruptedException {

        CounterUsingStream counterApp = new CounterUsingStream();
        int numberOfThreads = 1000;
        int numberOfIteration = 1000;
        CountDownLatch downLatch = new CountDownLatch(numberOfThreads);

        IntStream.rangeClosed(1,numberOfThreads)
                .<MyRunnable> mapToObj(i-> counterApp::inc)
                .map(myRunnable -> myRunnable.repeat(numberOfIteration))
                .map(myRunnable -> myRunnable.andThen(downLatch::countDown))
                .map(Thread::new)
                .forEach(Thread::start);

        downLatch.await();
        System.out.println(counterApp.counter);

    }

    private static interface MyRunnable extends Runnable{

        default MyRunnable repeat(int numberOfIteration){
           return ()-> IntStream.rangeClosed(1,numberOfIteration)
                    .forEach(i->run());

        }

        default MyRunnable andThen(MyRunnable after){
            return ()->{
                run();
                after.run();
            };
        }

    }
}
