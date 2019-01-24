import java.util.Scanner;

public class MyLinkedList<E> {
    private Node head;  //维护头指针可以作为哨兵节点方便程序编写
    private Node last;  //维护一个尾指针的目的是为了查找时使用折半查找,LinkedList源码也是通过这样进行折半查找
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

        last.previous = temp;   //如果有维护一个空尾指针，则加上这句

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

    //这个反转函数最简单，通过定义一个新链表
    public MyLinkedList<E> rotate() {
        MyLinkedList ml = new MyLinkedList();
        for (int i = size - 1; i >= 0; --i){
            ml.add(this.get(i));
        }
        return ml;
    }

    //这个反转函数只需要提供一个头指针位置即可，直接在原链表上操作。同时适用于单链表，和有无哨兵节点没关系。
    public void rotate2(){
        if (size < 1)
             throw new RuntimeException();
        Node<E> previous = head;
        Node<E> temp = previous.next;
        Node<E> end;
        previous.next = null;
        while (temp != null) {
            if (temp.next != null) {
                end = temp.next;
                temp.next = previous;
                previous = temp;
                temp = end;
            }else
                break;
        }
        temp.next = previous;
    }

    //这个打印函数用于在链表调用rotate2函数后进行遍历链表用的
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
