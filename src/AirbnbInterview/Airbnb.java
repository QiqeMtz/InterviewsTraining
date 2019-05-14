package AirbnbInterview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * At Airbnb, you could imagine total reservation costs are computed from a base price and some fees and taxes.
 * The base price may be an integer, but taxes and fees are percentage based, so the total amount could add up to be
 * non-whole number. Fox example, base price = 100, fee = 2.3 and taxes = 1.4, would lead to a net reservation cost
 * of 103.7. However, we want net reservation cost, to be shown on our website, to be an integer.
 *
 * Given base price, fee and taxes, we would like to round them such that they add up to a desired total while minimizing
 * the rounding error. More formally, we're going to solve the general case:
 *
 * Given numbers =prices=[x1, x2,...,Xn]= and target price =target=. We want to find a way to round each element in prices
 * such that after rounding, we get rounded numbers =roundedPrices=[y1, y2, ..., yn] such that y1+y2+...+yn = target where
 * yi = floor(xi) or Ceil(xi), floor or ceiling of xi. We also want to minimize the rounding error given by the sum = E|xi-yi|
 * for 1 <= i and i <= n. Return the rounded numbers roundedPrices.
 *
 * The test cases will guarantee that there is a valid unique output of roundedPrices
 *
 * Time Complexity restrictions
 * You should implement an algorithm that doest not use brute force to solve the problem
 *
 * Sample input
 * prices = [0.70, 2.80, 4.90]
 * targe = 8
 *
 * Sample output
 * [0,3,5]
 *
 * Explanation
 * roudedPrices = [0,3,5] with a total rounding error of 0.7 + 0.2 + 0.1 = 1. Thats better than [1,2,5], which has a total
 * rounding error of 0.3 + 0.8 +´0.1 = 1.2
 */
public class Airbnb {

    public static void main(String[] args) {
        LinkedList<Double> in = new LinkedList<>();
        in.add(.7);
        in.add(2.8);
        in.add(4.9);
        System.out.println(solve(in, 8));
    }

    static class Cost implements Comparable<Cost> {
        int idx;
        int roundDown;
        double diff;

        public Cost(int idx, double cost) {
            this.roundDown = (int) cost;
            this.idx = idx;
            this.diff = cost-roundDown;
        }

        // 1   izq>der
        // 0   izq==der
        // -1  izq<der
        @Override
        public int compareTo(Cost other) {
            return Double.compare(diff, other.diff);
        }
    }

    static List<Integer> solve(List<Double> in, int target) {
        Cost[] costs = new Cost[in.size()];
        int roundDownTarget = 0;
        for(int i=0;i<in.size(); i++){
            costs[i] =new Cost(i, in.get(i));
            roundDownTarget += costs[i].roundDown;
        }
        Arrays.sort(costs);
        int lastIdx = costs.length-1;
        while( roundDownTarget < target){
            costs[lastIdx--].roundDown++;
            roundDownTarget++;
        }
        Integer[] result = new Integer[costs.length];
        for(int i=0;i<costs.length;i++){
            result[costs[i].idx] = costs[i].roundDown;
        }

        return Arrays.asList(result);
    }
}


