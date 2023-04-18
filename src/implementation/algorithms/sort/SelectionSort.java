package implementation.algorithms.sort;

public class SelectionSort implements Sort {
    // todo find the problem
    // todo add counter (be smart)

    @Override
    public int sort(int[] array) {
        for (var i = 0; i < array.length; i++) {
            int mi = findMinIndex(array, i);
            swap(array, mi, i);
        }
        return 0;
    }

    private int findMinIndex(int[] array, int i) {
        var mi = i;
        for (var j = i; j < array.length; j++){
            if (array[j] < array[mi]) mi = j;
        }
        return mi;
    }

    private void swap(int[] array, int f, int s) {
        var tmp = array[f];
        array[f] = array[s];
        array[s] = tmp;
    }
}
