package implementation.dataStructures.stack;

public class Stack {
    private int[] elements;
    private static final int defaultSize = 10;
    private int pointer;

    public Stack() {
        this(defaultSize);
    }

    public Stack(int capacity) {
        this.elements = new int[capacity];
    }

    public void push(int element) {
        if (pointer == elements.length - 1)
            grow();

        elements[pointer++] = element;
    }

    public int pop() {
        if (pointer == 0)
            throw new ArrayIndexOutOfBoundsException();

        return elements[--pointer];
    }

    public int peek() {
        if (pointer == 0)
            throw new ArrayIndexOutOfBoundsException();

        return elements[pointer - 1];
    }

    public boolean isEmpty() {
        return pointer < 0;
    }

    public void grow() {
        var newArr = new int[elements.length + (elements.length / 2)];
        System.arraycopy(elements, 0, newArr, 0, elements.length);
        this.elements = newArr;
    }

    public void print() {
        for (int i = 0; i < pointer; i++) {
            System.out.printf("index: %d, value: %s%n", i, elements[i]);
        }
    }
}
