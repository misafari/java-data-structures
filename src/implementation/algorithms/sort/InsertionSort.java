package implementation.algorithms.sort;

public class InsertionSort implements Sort {
    @Override
    public int sort(int[] array) {
        var counter = 0;
        for (int i = 1; i < array.length; i++) {
            counter++;
            var current = array[i];

            int j = i - 1;
            for (; j >= 0 && array[j] > current; j--) {
                counter++;
                array[j + 1] = array[j];
            }

            array[j + 1] = current;
        }

        return counter;
    }
}
