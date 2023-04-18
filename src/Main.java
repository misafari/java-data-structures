import implementation.algorithms.sort.InsertionSort;
import implementation.algorithms.sort.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] simpleArray = {1, 50, 3, 23, 40, 2};
//        int[] sorted = {1, 2, 3};

        System.out.println(doSort(simpleArray, new InsertionSort()));

        System.out.println(Arrays.toString(simpleArray));
    }

    public static int doSort(int[] array, Sort sort) {
        return sort.sort(array);
    }
}