package Part11;

import Part06.MyFunction;

import java.util.Optional;

public class MyLinkedList<E> {
    private int size;
    private Node first;
    private Node last;

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

    public Optional<E> first(){
        return first==null
                ?Optional.empty()
                :Optional.of(first.data);
    }

    public Optional<E> last(){
        return last==null
                ?Optional.empty()
                :Optional.of(last.data);
    }

    public MyLinkedList<E> addFirst(E data){
        Node oldFirst=first;
        Node addNode=new Node(oldFirst,null,data);
        first=addNode;
        if (oldFirst==null)
            last=first;
        else
            oldFirst.prev=first;

        size++;
        return this;
    }



}
