import java.util.Scanner;

public class MyLinkedList<E> {
    private Node head;
    private Node last;
    private int size;
    public MyLinkedList() {
        clear();
    }

    private void clear() {
        this.head = new Node(null, null, null);
        this.last = new Node(head, null, null);
        head.next = last;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(E value) {
        Node<E> previous = head;
        Node<E> temp = new Node(head, value, null);
        for (int i = 0; i < size; ++i) {
            previous = previous.next;
        }
        temp.next = previous.next;
        previous.next = temp;
        temp.previous = previous;
        last.previous = temp;

        ++size;
    }

    public E get(int index) {
        Node<E> temp;
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException();
        if (index <= size / 2) {
            temp = head.next;
            for (int i = 0; i < index; ++i)
                temp = temp.next;
            return temp.value;
        }
        else {
            temp = last.previous;
            for (int i = size - 1; i > index; --i)
                temp = temp.previous;
            return temp.value;
        }
    }

    public void set(int index, E value) {
        Node<E> temp;
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException();
        if (index <= size / 2) {
            temp = head.next;
            for (int i = 0; i < index; ++i)
                temp = temp.next;
            temp.value = value;
        }
        else {
            temp = last.previous;
            for (int i = size - 1; i > index; --i)
                temp = temp.previous;
            temp.value = value;
        }
    }

    public MyLinkedList<E> rotate() {
        MyLinkedList ml = new MyLinkedList();
        for (int i = size - 1; i >= 0; --i){
            ml.add(this.get(i));
        }
        return ml;
    }

    public void rotate2(){
        Node<E> previous = head;
        Node<E> temp = previous.next;
        Node<E> end;
        while (temp != null) {
            if (temp.next != null) {
                end = temp.next;
                temp.next = previous;
                previous = temp;
                temp = end;
            }
            temp.next = previous;
        }
    }

    public void print() {
        Node<E> temp = last.next;
        while (temp.next != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private class Node<E> {
        E value;
        Node<E> previous;
        Node<E> next;
        public Node(Node<E> previous, E value, Node<E> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

}
