package Part12;

public class CreatingThreadApplication {
    public static void main(String[] args) {
        SimpleThread simpleThread=new SimpleThread("First Thread");
        SimpleThread secondThread=new SimpleThread("Second Thread");
        simpleThread.start();
        secondThread.start();
        System.out.println("MainThread");

    }

    private static class SimpleThread extends Thread{

        public SimpleThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Started: "+getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Completed "+getName());
        }
    }
}
