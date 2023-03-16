package implementation.tmp;

import java.util.NoSuchElementException;

public class LinkedList {
    // head
    private Node first;
    // tail
    private Node last;


    public void addFirst(int value) {
        var node = new Node(value);

        if (first == null) {
            first = last = node;
            return;
        }

        node.next = first;
        first = node;
    }

    public void removeFirst() {
        if (first == null)
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        first = first.next;
    }
}
