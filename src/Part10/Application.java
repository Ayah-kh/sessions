package Part10;

public class Application {
    public static void main(String[] args) {
        ExpandedArray<Integer> numbers=
                ExpandedArray.of(1,2,3,4,5,6,7,8,9,10);

        Integer sum = numbers.reduceL(0, acc -> e -> acc + e);
        System.out.println("sum = " + sum);
        String s = numbers.reduceL("", acc -> e -> acc + e);
        System.out.println("s = " + s);

        String s1 = numbers.reduceL("0", acc -> e -> "(" + acc + "+" + e + ")");
        System.out.println("s1 = " + s1);

        Integer sum2 = numbers.reduceR(0, e -> acc -> e + acc);
        System.out.println("sum2 = " + sum2);

        String s2 = numbers.reduceR("0", e -> acc -> "(" + acc + "+" + e + ")");
        System.out.println("s2 = " + s2);

        ExpandedArray<Integer> numBy2 = numbers.myMap(e -> e * 2);
        numBy2.forEach(System.out::println);

        ExpandedArray<String> stringNum = numbers.myMap(e -> "My number " + e);
        stringNum.forEach(System.out::println);

        ExpandedArray<Integer> evenNum = numbers.myFilter(e -> e % 2 == 0);
        evenNum.forEach(System.out::println);


    }
}
