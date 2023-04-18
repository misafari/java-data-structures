package implementation.dataStructures.array;

import java.util.NoSuchElementException;

public interface Array<T> {
    void add(T element);

    T get(int index) throws NoSuchElementException, ArrayIndexOutOfBoundsException;

    void remove(T element);

    void removeByIndex(int index);

    int indexOf(T element);

    boolean contains(T element);

    int size();

    void print();
}
