package implementation.dataStructures.map;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyHashMap {
    private LinkedList<Entry>[] entries;

    public MyHashMap() {
        this.entries = new LinkedList[5];
    }

    public void put(int incomeKey, String value) {
        var index = hash(incomeKey);
        var entry = new Entry(incomeKey, value);

        if (entries[index] == null) {
            entries[index] = new LinkedList<>();
            entries[index].addLast(entry);
            return;
        }

        var bucket = entries[index];

        if (bucket.stream().anyMatch(e -> e.key == incomeKey)) {
            return;
        }

        bucket.addLast(entry);
    }

    public String get(int key) throws NoSuchElementException {
        var bucket = getBucket(key);

        if (bucket == null) throw new NoSuchElementException();

        var entry = bucket.stream().filter(e -> e.key == key).findFirst();

        return entry.orElseThrow(NoSuchElementException::new).value;
    }

    public void remove(int key) throws IllegalStateException {
        var bucket = getBucket(key);

        if (bucket == null) throw new IllegalStateException();

        boolean isDone = bucket.removeIf(e -> e.key == key);

        if (!isDone) throw new IllegalStateException();
    }

    private int hash(int key) {
        return key % entries.length;
    }

    private LinkedList<Entry> getBucket(int key) {
        var index = hash(key);
        return entries[index];
    }
}
