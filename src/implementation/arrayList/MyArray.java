package implementation.arrayList;

// you are not allowed to import any classes

import implementation.array.Array;

public class MyArray<T> implements Array<T> {
    private static final byte initialCapacity = 10;
    private Object[] elements;
    private int size;

    public MyArray() {
        this(initialCapacity);
    }

    public MyArray(final int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("initial capacity must be greater than 0");

        elements = new Object[initialCapacity];
    }

    @Override
    public void add(T element) {
        if (elements.length == size) {
            Object[] newBag = new Object[size + (size / 2)];

            for (int i = 0; i < elements.length; i++) {
                newBag[i] = elements[i];
            }

            elements = newBag;
        }

        elements[size++] = element;
    }

    @Override
    public T get(int index) {
        indexRangeValidation(index);
        return (T) elements[index];
    }

    @Override
    public void remove(T element) {
        var index = indexOf(element);
        if (index == -1)
            return;

        removeByIndex(index);
    }

    @Override
    public void removeByIndex(int index) {
        indexRangeValidation(index);

        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element)
                return i;
        }

        return -1;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) > -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.printf("index: %d, value: %s%n", i, elements[i]);
        }
    }

    private void indexRangeValidation(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index should be greater than 0 or less than %d".formatted(size));
    }
}
