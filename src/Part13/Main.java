package Part13;

public class Main {
    public static void main(String[] args) {

        int[] numbers={1,2,3,4,5};
        System.out.println("numbers[4] = " + numbers[4]);


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
