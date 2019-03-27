package BeginningDataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionImproved {
    public static void main(String[] args) {

        int[] a = new int[]{5,7,9,8,4,3,2,1,10,11,13,12,14,16,15};
        int[] b = new int[]{200,100,101,23,55,5,7,9,8,4,3,2,1,10,11,13,12,14,16,15};

        System.out.println(intersectionFast(a,b));
    }

    private static List<Integer> intersectionFast(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> result = new ArrayList<>();

        for(int x : a) {
            if (binarySearch(x, b))
                result.add(x);
        }
        return result;
    }

    private static boolean binarySearch(int x, int[] sortedNumbers) {
        int end = sortedNumbers.length - 1;
        int start = 0;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (sortedNumbers[mid] == x) return true;
            else if (sortedNumbers[mid] > x) end = mid -1;
            else start = mid + 1;
        }
        return false;
    }
}
