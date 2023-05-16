package Part11;

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




    }
}
