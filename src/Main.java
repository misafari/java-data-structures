import implementation.sort.SelectionSort;
import implementation.sort.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] simpleArray = {1, 50, 3, 23, 40, 2};
        int[] sorted = {1, 2, 3};

        doSort(sorted, new SelectionSort());

        System.out.println(Arrays.toString(sorted));
    }

    public static void doSort(int[] array, Sort sort) {
        sort.sort(array);
    }
}