package implementation.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class BubbleSort implements Sort {
    @Override
    public int sort(int[] array) {
        return secondImpl(array);
    }

    // prob: unnecessary iteration
    private int firstImpl(int[] array) {
        AtomicInteger countOfIt = new AtomicInteger();
        Arrays.stream(array).forEach(ff -> {
            countOfIt.getAndIncrement();
            for (int i = 1; i < array.length; i++) {
                countOfIt.getAndIncrement();
                if (array[i] < array[i - 1])
                    swap(array, i, i - 1);
            }
        });

        return countOfIt.get();
    }

    // prob: unnecessary iteration (if it is sorted)
    private int secondImpl(int[] array) {
        var count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            for (int j = 1; j < array.length - i; j++) {
                count++;
                if (array[j] < array[j - 1])
                    swap(array, j, j - 1);
            }
        }
        return count;
    }

    private int thirdImpl(int[] array) {
        var count = 0;
        var isSorted = true;
        for (int i = 0; i < array.length; i++) {
            count++;
            for (int j = 1; j < array.length - i; j++) {
                count++;
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }

            if (isSorted) break;
        }
        return count;
    }

    private void swap(int[] array, int f, int s) {
        var tmp = array[f];
        array[f] = array[s];
        array[s] = tmp;
    }
}
