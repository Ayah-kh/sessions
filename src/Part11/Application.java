package Part11;

public class Application {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList=new MyLinkedList<>();
        myLinkedList.add(5);
        myLinkedList.add(8);
        myLinkedList.add(9);
        myLinkedList.add(10);
        myLinkedList.add(11);
        myLinkedList.add(15);

        myLinkedList.forEach(System.out::println);


    }
}
