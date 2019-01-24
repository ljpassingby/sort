import java.util.LinkedList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> ml = new MyLinkedList();
        ml.add("abc");
        ml.add("def");
        ml.add("def1");
        ml.add("def2");
        ml.add("def3");
        ml.rotate2();
        ml.print();
    }
}

