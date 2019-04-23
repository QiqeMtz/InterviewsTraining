package Sorting;

import java.util.Arrays;

public class SelectionSorting {
    public static void main(String[] args) {

        int[] numbers = new int[] {1,5,4,7,2,3, 10000000};

        SelectionSort sort = new SelectionSort();

        int[] sorted = sort.doSort(numbers);

        System.out.println(Arrays.toString(sort.doSort(sorted)));
    }

    static class SelectionSort {
        int[] doSort(int[] numbers) {
            int length = numbers.length;

            for (int i = 0; i < length - 1; i++) {
                int minIdx = i;

                for (int j = i + 1; j < length; j++)
                    if (numbers[j] < numbers[minIdx])
                        minIdx = j;

                int temp = numbers[minIdx];
                numbers[minIdx] = numbers[i];
                numbers[i] = temp;
            }
            return numbers;
        }
    }
}
