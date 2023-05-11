package Part06;

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



    }


}
