package implementation.array.linkedList;


import implementation.array.Array;

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
            node.setNext(first);
            first = node;
        }

        size++;
    }

    public void addLast(T element) {
        var node = new Node<>(element);

        if (isEmpty())
            first = last = node;
        else {
            last.setNext(node);
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

        var second = first.getNext();
        first.setNext(null);
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

        while (prevLastNode != null) {
            if (prevLastNode.getNext() == last) break;
            prevLastNode = prevLastNode.getNext();
        }

        assert prevLastNode != null;
        prevLastNode.setNext(null);
        last = prevLastNode;

        size--;
    }

    public boolean contains(T element) {
        return indexOf(element) > -1;
    }

    public int indexOf(T element) {
        var selectedNode = first;
        var index = 0;

        while (selectedNode != null) {
            if (selectedNode.contain(element)) {
                return index;
            }

            index++;
            selectedNode = selectedNode.getNext();
        }

        return -1;
    }

    public void reverse() {
        if (isEmpty()) return;

        if (first == last) return;

        var preNode = first;
        var selectedNode = first.getNext();

        while (selectedNode != null) {
            var nextNode = selectedNode.getNext();

            selectedNode.setNext(preNode);
            preNode = selectedNode;
            selectedNode = nextNode;
        }

        last = first;
        last.setNext(null);
        first = preNode;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public T get(int index) throws NoSuchElementException, ArrayIndexOutOfBoundsException {
        if (isEmpty()) throw new NoSuchElementException();

        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();

        var steps = 0;
        var selectedNode = first;

        while (index != steps) {
            selectedNode = selectedNode.getNext();
            steps++;
        }

        return selectedNode.getValue();
    }

    @Override
    public void remove(T element) throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();

        var selectedNode = first;
        var prevNode = first;

        while (!selectedNode.contain(element)) {
            if (selectedNode.getNext() == null) {
                return;
            }
            prevNode = selectedNode;
            selectedNode = selectedNode.getNext();
        }

        if (prevNode == selectedNode) {
            deleteFirst();
        }

        prevNode.setNext(selectedNode.getNext());
        size--;
    }

    @Override
    public void removeByIndex(int index) {
        if (isEmpty()) throw new NoSuchElementException();

        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();

        var steps = 0;
        var selectedNode = first;
        var prevNode = first;

        while (index != steps) {
            if (selectedNode.getNext() == null) {
                return;
            }

            prevNode = selectedNode;
            selectedNode = selectedNode.getNext();
            steps++;
        }

        if (prevNode == selectedNode) {
            deleteFirst();
        }

        prevNode.setNext(selectedNode.getNext());
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    public void print() {
        if (first == null) {
            System.out.println("[]");
            return;
        }

        if (first == last) {
            System.out.println(first.getValue());
            return;
        }

        var selectedNode = first;

        while (selectedNode != null) {
            System.out.println(selectedNode.getValue());
            selectedNode = selectedNode.getNext();
        }
    }

    private boolean isEmpty() {
        return first == null;
    }
}
