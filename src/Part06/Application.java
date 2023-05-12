package Part06;

import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        MyFunction<String, String> helloMsg = a -> "Hello " + a;
        String ahamd = helloMsg.apply("ahamd");
        System.out.println("ahamd = " + ahamd);

        MyFunction<Integer, Integer> inc = a -> a + 1;
        Integer num = inc.apply(5);
        System.out.println("num = " + num);

        MyFunction<String,Integer> strLength= String::length;
        System.out.println("strLength.apply(\"Mohammed\") = " + strLength.apply("Mohammed"));

        int num2=inc.apply(strLength.apply("HELLO wo"));
        System.out.println("num2 = " + num2);

        MyFunction<String, Integer> compose = strLength.compose(helloMsg);

        MyFunction<String,Integer> compose2=(strLength= String::length).compose(s -> "Hello "+s);
        System.out.println("compose.apply(\"Heeelo\") = " + compose.apply("Heeelo"));

        IntOperation add5 = a -> a + 5;
        IntOperation mult10 = a -> a * 10;

        IntPredicate isEven = a -> a % 2== 0;
        System.out.println("isEven.test(10) = " + isEven.test(10));
        System.out.println("isEven.test(1) = " + isEven.test(1));

        IntPredicate isOdd=a->a%2!=0;
        System.out.println(isOdd.test(10));

        IntPredicate dividableBy7= a -> a%7!=0;
        System.out.println("dividableBy7.test(15) = " + dividableBy7.test(15));

        MyPredicate<Integer> isEven2=a->a%2==0;
        MyPredicate<String> startWithA=a->a.startsWith("a");

        MyPredicate<User> salaryGT1000=user -> user.getSalary()>1000;
        MyPredicate<User> nameStartWithA=user -> user.getName().startsWith("A");

        User mohammed = new User("1", "Mohammed", 40, 900);
        User ahmad = new User("2", "Ahmad", 30, 1200);

        System.out.println(salaryGT1000.test(mohammed));
        System.out.println("nameStartWithA.test(ahmad) = " + nameStartWithA.test(ahmad));

        MyConsumer<User> printUser=user -> System.out.println(user.getName());
        printUser.apply(mohammed);

        MyPredicate<User> and = salaryGT1000.and(nameStartWithA);
        MyPredicate<User> notGT1000 = salaryGT1000.not();
        System.out.println(notGT1000.test(mohammed));

    }


}
