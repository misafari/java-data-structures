package implementation.array.linkedList;


import implementation.array.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
// you are not allowed to import any classes

public class SinglyLinkedList<T> implements Array<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public SinglyLinkedList() {
    }

    public void addFirst(T element) {
        var node = new Node<>(element);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void addLast(T element) {
        var node = new Node<>(element);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size--;
            return;
        }

        var second = first.next;
        first.next = null;
        first = second;

        size--;
    }

    public void deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size--;
            return;
        }


        var prevLastNode = first;

        for (; prevLastNode != null; prevLastNode = prevLastNode.next) {
            if (prevLastNode.next == last) break;
        }

        assert prevLastNode != null;
        prevLastNode.next = null;
        last = prevLastNode;

        size--;
    }

    public boolean contains(T element) {
        return indexOf(element) > -1;
    }

    public int indexOf(T element) {
        var index = 0;
        for (var s = first; s != null; s = s.next) {
            if (s.contain(element))
                return index;

            index++;
        }

        return -1;
    }

    public void reverse() {
        if (isEmpty()) return;

        if (first == last) return;

        var preNode = first;
        var selectedNode = first.next;

        while (selectedNode != null) {
            var nextNode = selectedNode.next;

            selectedNode.next = preNode;
            preNode = selectedNode;
            selectedNode = nextNode;
        }

        last = first;
        last.next = null;
        first = preNode;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public T get(int index) throws NoSuchElementException, ArrayIndexOutOfBoundsException {
        if (isEmpty())
            throw new NoSuchElementException();

        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException();

        var steps = 0;
        var s = first;

        for (; index != steps; s = s.next)
            steps++;

        return s.value;
    }

    @Override
    public void remove(T element) throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            deleteFirst();
            return;
        }

        var selectedNode = first;
        var prevNode = first;

        while (!selectedNode.contain(element)) {
            if (selectedNode.next == null)
                return;

            prevNode = selectedNode;
            selectedNode = selectedNode.next;
        }

        prevNode.next = selectedNode.next;
        size--;
    }

    @Override
    public void removeByIndex(int index) {
        if (isEmpty())
            throw new NoSuchElementException();

        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException();

        if (first == last) {
            deleteFirst();
            return;
        }

        var steps = 0;
        var selectedNode = first;
        var prevNode = first;

        while (index != steps) {
            if (selectedNode.next == null)
                return;

            prevNode = selectedNode;
            selectedNode = selectedNode.next;
            steps++;
        }

        prevNode.next = selectedNode.next;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    public Object[] toArray() {
        var array = new Object[size];

        var i = 0;
        for (var s = first; s != null; s = s.next)
            array[i++] = s.value;

        return array;
    }

    public T getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;

            if (b == null)
                throw new IllegalArgumentException();
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    public String toString() {
        if (first == null) return "[]";

        if (first == last) return "[%s]".formatted(first.value);

        var sb = new StringBuilder("[");

        for (var s = first; s != null; s = s.next) {
            sb.append(s.value);

            if (s != last)
                sb.append(",");
        }

        sb.append("]");

        return sb.toString();
    }

    private boolean isEmpty() {
        return first == null;
    }
}
