package array;

public interface Array {
    void add(int element);
    void remove(int element);
    void removeByIndex(int index);
    int indexOf(int element);
    boolean contains(int element);
    int size();
    void print();
}
