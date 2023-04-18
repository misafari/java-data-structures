package implementation.dataStructures.map;

public class Entry {
    int key;
    String value;

    public Entry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Entry empty() {
        return new Entry(0, null);
    }
}
