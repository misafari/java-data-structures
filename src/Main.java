
import implementation.array.linkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> a = new SinglyLinkedList<>();

        a.add(10);
        a.add(20);
        a.add(30);
        a.add(40);
        a.add(50);

        System.out.println(a.getKthFromTheEnd(2));
    }
}