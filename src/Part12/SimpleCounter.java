package Part12;

public class SimpleCounter {
    private int counter;

    public void inc(){
        counter++;
    }

    public void dec(){
        counter--;
    }

    public static void main(String[] args) {
        SimpleCounter simpleCounter=new SimpleCounter();\
        int numberOfThreads=3;

        for (int i = 0; i <numberOfThreads ; i++) {
            new Thread(()->simpleCounter.inc()).start();

        }
    }
}
