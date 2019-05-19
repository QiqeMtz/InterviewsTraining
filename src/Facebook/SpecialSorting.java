package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpecialSorting {
    public static void main(String[] args) {
        int x = 6;
        int n = 3;
        int[] A = new int[]{6,5,4,3,2,1};
        int[] X = new int[]{0,3,5};

        int[] result = solve(A, X, x, n);
        System.out.println(Arrays.toString(result));

        x = 5;
        n = 3;
        A = new int[]{12,1,3,10,5};
        X = new int[]{1,2};

        result = solve(A, X, x, n);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solve(int[] A, int[] B, int sizeA, int sizeB) {
        // My result array has zeros in empty positions, check how to avoid if the input array contains any zero
        int[] result = new int[sizeA];

        List<Integer> numbersToSort = new ArrayList<Integer>();
        List<Integer> indexesToAvoid = new ArrayList<>();

        for(int index : B) {
            indexesToAvoid.add(Integer.valueOf(index));
            result[index] = A[index];
        }

        for(int i = 0; i < sizeA; i++) {
            if(indexesToAvoid.contains(i)) {
                continue;
            }
            numbersToSort.add(Integer.valueOf(A[i]));
        }

        Collections.sort(numbersToSort);

        int listIdx = 0;
        for (int i = 0; i < result.length; i++) {
            if(result[i] == 0) {
                result[i] = numbersToSort.get(listIdx);
                listIdx++;
            }
        }

        return result;
    }
}
