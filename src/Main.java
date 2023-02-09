
import implementation.array.linkedList.SinglyLinkedList;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> a = new SinglyLinkedList<>();
        List<Integer> b = new LinkedList<>();

        a.add(10);
        a.add(20);
        a.add(30);
        a.add(40);
        a.add(50);

        a.reverse();

        a.print();
    }
}