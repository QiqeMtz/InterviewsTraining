package Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{100000,100,5006,5,4,3,2,1,0,89,90,99,15,11};

        BubbleSorting bubbleSort = new BubbleSorting();

        System.out.println(Arrays.toString(bubbleSort.sort(numbers)));
        System.out.println(Arrays.toString(bubbleSort.sortImprovement1(numbers)));
        System.out.println(Arrays.toString(bubbleSort.sortImprovement2(numbers)));
    }

    static class BubbleSorting {
        int[] sort(int[] numbers) {
            for (int i = 1; i < numbers.length ; i++) {
                for (int j = 0; j < numbers.length -1; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }
            }
            return numbers;
        }

        int[] sortImprovement1(int[] numbers) {
            for (int i = 1; i < numbers.length ; i++) {
                for (int j = 0; j < numbers.length - i; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }
            }
            return numbers;
        }

        int[] sortImprovement2(int[] numbers) {
            int i = 0;
            boolean swapped = true;

            while (swapped) {
                swapped = false;
                i++;

                for (int j = 0; j < numbers.length - i; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                        swapped = true;
                    }
                }
            }
            return numbers;
        }
    }
}
