package Part13;

public class Main {
    public static void main(String[] args) {
        try {
            int a = 3/0;
        }catch (ArithmeticException e) {
            System.out.println("div by 0");
        }

        System.out.println("Hello");

        try {
            sleepV1(2);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupt");
        }


    }

    private static void sleepV1(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    private static void sleepV2(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }

    }
}
