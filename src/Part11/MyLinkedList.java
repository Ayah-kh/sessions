package Part11;

import java.util.Optional;

public class MyLinkedList<E> {
    private int size;
    private Node first;
    private Node last;

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

    private E removeNode(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;

        if (prevNode==null)
            first=nextNode;
        else
            prevNode.next=nextNode;

        if (nextNode==null)
            last=prevNode;
        else
            nextNode.prev=prevNode;

        size--;
        return node.data;
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
