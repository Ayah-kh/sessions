package part1;

public class Main {
    public static void main(String[] args) {
        Increment inc =new IncImp();
        System.out.println("inc.inc(10) = " + inc.inc(10));

        Increment inc2=v->v+1;
        System.out.println("inc2 = " + inc2);

        StringOperation toUpper=a->a.toUpperCase();
        System.out.println("toUpper.apply(\"hello\") = " + toUpper.apply("hello"));
        StringOperation toLower=a->a.toLowerCase();
        System.out.println("toLower.apply(\"HELLO\") = " + toLower.apply("HELLO"));
        StringOperation helloMasg=a->"Hello "+a;
        System.out.println("helloMasg.apply(\"Ayah\") = " + helloMasg.apply("Ayah"));

        IntOperation add5=a->a+5;
        IntOperation multBy10=a->a*10;




    }
    static class IncImp implements Increment{

        @Override
        public int inc(int a) {
            return a+1;
        }
    }
}