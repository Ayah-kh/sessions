package Part11;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        MyLinkedList<Integer> numbers = new MyLinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        numbers.forEach(System.out::println);

        numbers.map(a -> a * 2).forEach(System.out::println);
        System.out.println("==============================");

        numbers.flatMap(a -> MyLinkedList.of(a - 1, a, a + 1)).forEach(System.out::println);

        Integer sum = numbers.reduceL(0, acc -> e -> acc + e);
        System.out.println("sum = " + sum);

        System.out.println("numbers.allMatch(a->a%10) = " + numbers.allMatch(a -> a % 10==0));

        MyLinkedList<Integer> numbers2 = numbers.addAll(MyLinkedList.of(1, 2, 3));
        numbers2.forEach(System.out::println);

        System.out.println("------------------------------");

        numbers.anyMatch(a ->{
            System.out.println(a);
           return a % 2 == 0;
        });

        Optional<Integer> min = numbers.min(Integer::compare);
        Optional<Integer> max = numbers.max(Integer::compare);
        System.out.println("__________________________________");
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("__________________________________");
        numbers.filter(a->a>30)
                .forEach(System.out::println);

        System.out.println("__________________________________");
        Stream.iterate(1,a->a+1)
                .limit(20)
                .forEach(System.out::println);

        System.out.println( range(1, 10).sum());

        numbers.stream().forEach(System.out::println);

    }

    public static IntStream range(int from, int toInclude){
       return IntStream.iterate(from,acc->acc<=toInclude,a->a+1);
    }
}
