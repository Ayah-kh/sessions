package Part12;

public class CreatingThreadUsingRunnable {
    public static void main(String[] args) {
        Runnable toDo=() -> {
            System.out.println("Started: ");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Completed: ");
        };

        Thread thread = new Thread(toDo);

        thread.start();
    }
}
