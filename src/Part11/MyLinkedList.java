package Part11;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyLinkedList<E> {
    private int size;
    private Node first;
    private Node last;

    public static <E> MyLinkedList<E> of(E... data) {
        MyLinkedList<E> myLinkedList = new MyLinkedList<>();
        for (E datum : data) {
            myLinkedList.addLast(datum);
        }

        return myLinkedList;
    }

    public MyLinkedList<E> add(E data) {
        return addLast(data);
    }

    public Optional<E> first() {
        return first == null
                ? Optional.empty()
                : Optional.of(first.data);
    }

    public Optional<E> last() {
        return last == null
                ? Optional.empty()
                : Optional.of(last.data);
    }

    public MyLinkedList<E> addFirst(E data) {
        Node oldFirst = first;
        Node addNode = new Node(oldFirst, null, data);
        first = addNode;
        if (oldFirst == null)
            last = first;
        else
            oldFirst.prev = first;

        size++;
        return this;
    }

    public MyLinkedList<E> addLast(E data) {
        Node oldLast = last;
        Node addLast = new Node(null, oldLast, data);
        last = addLast;
        if (oldLast == null)
            first = last;
        else
            oldLast.next = last;

        size++;
        return this;
    }

    public Optional<E> removeFirst() {

        return first == null
                ? Optional.empty()
                : Optional.of(removeNode(first));
    }

    public Optional<E> removeLast() {

        return last == null
                ? Optional.empty()
                : Optional.of(removeNode(last));
    }

    private E removeNode(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;

        if (prevNode == null)
            first = nextNode;
        else
            prevNode.next = nextNode;

        if (nextNode == null)
            last = prevNode;
        else
            nextNode.prev = prevNode;

        size--;
        return node.data;
    }

    public <U> U reduceR(U seed, Function<E, Function<U, U>> function) {
        return reduceR(seed, function, last);
    }

    private <U> U reduceR(U acc, Function<E, Function<U, U>> function, Node node) {
        return node == null
                ? acc
                : reduceR(function.apply(node.data).apply(acc)
                , function
                , node.prev
        );
    }


    public <U> U reduceL(U seed, Function<U, Function<E, U>> function) {
        return reduceL(seed, function, first);
    }

    private <U> U reduceL(U acc, Function<U, Function<E, U>> function, Node node) {
        return node == null
                ? acc
                : reduceL(function.apply(acc).apply(node.data)
                , function
                , node.next);
    }

    public void forEach(Consumer<E> consumer) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            consumer.accept(node.data);
            node = node.next;
        }
    }

    public <U> MyLinkedList<U> map(Function<E, U> function) {
        return reduceL(new MyLinkedList<U>(), acc -> e -> acc.addLast(function.apply(e)));
    }

    public <U> MyLinkedList<U> flatMap(Function<E, MyLinkedList<U>> function) {
        return reduceL(new MyLinkedList<>(),
                aac -> e -> aac.addAll(function.apply(e)));
    }

    public MyLinkedList<E> addAll(MyLinkedList<E> anotherList) {
        return anotherList.reduceL(this, acc -> e -> acc.addLast(e));
    }

    public MyLinkedList<E> reversed() {
        return reduceR(new MyLinkedList<>(), e -> acc -> acc.addLast(e));
    }

    public boolean allMatch(Predicate<E> predicate) {
        return reduceL(true, acc -> e -> acc && predicate.test(e));
    }

    private class Node {
        private Node next;
        private Node prev;
        private E data;

        public Node(Node next, Node prev, E data) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }


}
