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
        System.out.println("addFive. apply(10) = " + addFive.apply(10));

        MyIntFunction addFive2= a->a+5;
        System.out.println("addFive2.apply(10) = " + addFive2.apply(10));

        MyIntFunction multBy5=a->a*5;
        System.out.println("multBy5. apply(10) = " + multBy5.apply(10));

        MyIntFunction compose = addFive2.compose(multBy5);
        System.out.println("compose.  apply(4) = " + compose.apply(4));

        MyFunction<String,String> greeting=a->"Hello "+a;
        MyFunction<String,String> toCaps=a->a.toUpperCase();
        MyFunction<String, String> compose1 = greeting.compose(toCaps);
        System.out.println("compose1.apply(\"Hello\") = " + compose1.apply("Hello"));
        MyFunction<String, String> compose2 = toCaps.compose(greeting);
        System.out.println("compose2.apply(\"yasmeen\") = " + compose2.apply("yasmeen"));

        User mohammed=new User("Mohammed");

        MyFunction<User,String> getname=u->u.getName();
        MyFunction<User, String> compose3 = greeting.compose(getname);
        System.out.println("compose3.apply(mohammed) = " + compose3.apply(mohammed));


    }
}
