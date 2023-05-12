package Part06;

import java.util.function.Function;
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

        MyBiFunction<Integer,Integer,Integer> add=(a,b)->a+b;
        System.out.println("add.apply(1,3) = " + add.apply(1, 3));

        CBiFunction<Integer,Integer,Integer> cAdd=a->b->a+b;
        System.out.println("cAdd.apply(1).apply(3) = " + cAdd.apply(1).apply(3));

        MyFunction<Integer, Integer> partialApply = cAdd.apply(5);
        Integer apply = partialApply.apply(6);
        System.out.println(apply);

        CBiFunction<Integer,Integer,Double> itemPriceWithTax=tax->itemPrice->itemPrice+(double)(itemPrice*tax)/100;
        System.out.println("itemPriceWithTax.apply(16).apply(100) = " + itemPriceWithTax.apply(16).apply(100));
        MyFunction<Integer, Double> netPriceInJordan = itemPriceWithTax.apply(16);
        System.out.println("netPrice.apply(100) = " + netPriceInJordan.apply(100));
        System.out.println("netPrice.apply(50) = " + netPriceInJordan.apply(50));
        MyFunction<Integer, Double> netPriceInSuadi = itemPriceWithTax.apply(3);
        System.out.println("netPriceInSuadi.apply(100) = " + netPriceInSuadi.apply(100));
        System.out.println("netPriceInSuadi.apply(50) = " + netPriceInSuadi.apply(50));

        CBiFunction<Integer, Integer, Double> flipped = itemPriceWithTax.flipParameters();
        System.out.println("itemPriceWithTax.apply(100).apply(16) = " + flipped.apply(100).apply(16));

        MyFunction<Integer,MyFunction<Integer,Integer>> add3=a->b->a+b;

        MyFunction<Integer, MyFunction<Integer,MyFunction<Integer,Integer>>> function=a->b->c->a+b+c;



    }


}
