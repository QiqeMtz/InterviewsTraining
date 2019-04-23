package Special;


/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and
 * we need to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
 * for which the price of the stock on the current day is less than or equal to its price on the given day
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
 *                                                      {100, 90, 80, 70, 60, 50, 40},
 *                                                      {40, 50, 60, 70, 80, 90, 100},
 *                                                      {100, 90, 80, 70, 80, 90, 100},
 *                                                      {40, 50, 60, 70, 60, 50, 40},
 *                                                      {101, 70, 80, 50, 60, 71, 100},
 *                                                      {  1,  1,  2,  1,  2,  3,  5+1}
 * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */
public class StockSpan {

    public static void main(String[] args) {

    }
}
