package Part05;

import Part06.IntOperation;
import Part06.IntPredicate;
import Part06.StringOperation;

public class Application2 {
    public static void main(String[] args) {
        StringOperation toUpper = a -> a.toUpperCase();
        System.out.println("toUpper.apply(\"Hello\") = " + toUpper.apply("Hello"));

        StringOperation toLower = a -> a.toLowerCase();
        System.out.println("toLower.apply(\"HELLO\") = " + toLower.apply("HELLO"));

        StringOperation helloMsg = a -> "Hello " + a;
        System.out.println("helloMsg.apply(\"Ayah\") = " + helloMsg.apply("Ayah"));

        Operation<String> operation = a -> System.out.println(a);




    }
}
