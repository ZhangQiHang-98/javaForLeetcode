package sort;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int curMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[i] < arr[j] ? minIndex : j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
