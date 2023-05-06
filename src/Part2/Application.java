package Part2;

import part1.Increment;

public class Application {

    public static void main(String[] args) {
        MyFunction<String,String> helloMsg=a->"Hello "+a;
        System.out.println("helloMsg.apply(\"Ahmad\") = " + helloMsg.apply("Ahmad"));
        MyFunction<Integer,Integer> inc=a->a+1;
        System.out.println("inc.apply(10) = " + inc.apply(10));
        MyFunction<String, Integer> strlength=a->a.length();
        System.out.println("strlength.apply(\"ayah\") = " + strlength.apply("ayah"));

        MyFunction<String, Integer> compose = strlength.compose(helloMsg);
        System.out.println(compose.apply("Mohammed"));

        MyClass1 myClass1=new MyClass1();
        System.out.println(myClass1.apply(10));
        System.out.println("myClass1.apply(myClass1.apply(10)) = " + myClass1.apply(myClass1.apply(10)));
    }
}
