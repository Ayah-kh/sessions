package Part04;

import java.util.function.IntFunction;

public class Application {

    static class AddFive implements IntFunction{

        @Override
        public Object apply(int a) {
            return a+5;
        }
    }
    public static void main(String[] args) {
        AddFive addFive=new AddFive();
        System.out.println("addFive.apply(10) = " + addFive.apply(10));

    }
}
