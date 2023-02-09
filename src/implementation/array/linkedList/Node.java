package implementation.array.linkedList;

public class Node<T> {
    private final T value;
    private Node<T> next;

    public Node(T value) {
        this(value, null);
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public boolean contain(T value) {
        return this.value == value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
