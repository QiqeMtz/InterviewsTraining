package BeginningDataStructuresAndAlgorithms;

/**
 * Class with a Binary Search implementation
 * This algorithm has logn^2 complexity
 */
public class BinarySearch {

    public static void main(String[] args) {

        Binary binarySearch = new Binary();
        int[] sortedNumbers = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        System.out.println(binarySearch.doSearch(15, sortedNumbers));
    }

    static class Binary {

        int doSearch(int x, int[] sortedNumbers) {
            int end = sortedNumbers.length - 1;
            int start = 0;

            while (start <= end) {
                int mid = (end - start) / 2 + start;
                if (sortedNumbers[mid] == x) return mid;
                else if (sortedNumbers[mid] > x) end = mid -1;
                else start = mid + 1;
            }
            return -1;
        }
    }

}
