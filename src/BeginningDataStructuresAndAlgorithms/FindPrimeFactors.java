package BeginningDataStructuresAndAlgorithms;

import java.util.ArrayList;

public class FindPrimeFactors {
    public static void main(String[] args) {

        System.out.println(primeFactors(2100078578));

        System.out.println(primeFactors(2100078577));
    }

    private static ArrayList<Long> primeFactors(long x) {
        ArrayList<Long> result = new ArrayList<>();
        long factor = 2;

        while (x > 1) {
            if (x % factor == 0) {
                result.add(factor);
                x /= factor;
            } else {
                factor += 1;
            }
        }
        return result;
    }
}
