package Part06;

public class Application {
    public static void main(String[] args) {
        MyFunction<String, String> helloMsg = a -> "Hello " + a;
        String ahamd = helloMsg.apply("ahamd");
        System.out.println("ahamd = " + ahamd);

        MyFunction<Integer, Integer> inc = a -> a + 1;
        Integer num = inc.apply(5);
        System.out.println("num = " + num);

        MyFunction<String,Integer> strLength=a->a.length();
        System.out.println("strLength.apply(\"Mohammed\") = " + strLength.apply("Mohammed"));


    }


}
