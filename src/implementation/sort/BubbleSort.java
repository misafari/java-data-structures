package implementation.sort;

import implementation.sort.Sort;

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] array) {
        var isSorted = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }

    private void swap(int[] array, int f, int s) {
        var tmp = array[f];
        array[f] = array[s];
        array[s] = tmp;
    }
}
