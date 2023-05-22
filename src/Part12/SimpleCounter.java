package Part12;

public class SimpleCounter {
    private int counter;

    public void inc(){
        counter++;
    }

    public void dec(){
        counter--;
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleCounter simpleCounter=new SimpleCounter();
        int numberOfThreads=10;

        for (int i = 0; i <numberOfThreads ; i++) {
            new Thread(()->simpleCounter.inc()).start();
        }
        Thread.sleep(2000);
        System.out.println("simpleCounter.counter = " + simpleCounter.counter);
    }
}
