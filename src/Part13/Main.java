package Part13;

public class Main {
    public static void main(String[] args) {
        try {
            int a = 3/0;
        }catch (ArithmeticException e) {
            System.out.println("div by 0");
        }

        System.out.println("Hello");



    }
}
