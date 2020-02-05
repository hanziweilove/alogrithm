package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ziweihan on 6/19/19.
 *
 * 123. Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

 Example 1:

 Input: [3,3,5,0,0,3,1,4]
 Output: 6
 Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

 Example 2:

 Input: [1,2,3,4,5]
 Output: 4
 Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 engaging multiple transactions at the same time. You must sell before buying again.

 Example 3:

 Input: [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStockIII_H {

    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;

        int[] left = new int[prices.length];   //stores max profit from 0 to i
        int[] right = new int[prices.length];  //stores max profit from i to len-1

        process(prices, left,right); //populate left and right array

        int max_profit=0; //initial max val
        for(int i=0; i<prices.length; i++){
            max_profit = Math.max(max_profit, left[i]+right[i]); //update and find the max profit combination
        }

        return max_profit;
    }

    public void process(int[] prices, int[] left, int[] right){
        int min=prices[0];
        left[0]=0;

        for(int i=1; i<prices.length; i++){  //update min and store max profit from the left
            min = Math.min(min, prices[i]);
            left[i] = Math.max(prices[i]-min, left[i-1]);
        }

        int max=prices[prices.length-1];
        right[right.length-1]=0;

        for(int i=prices.length-2; i>=0; i--){  //update max and store max profit from the right
            max = Math.max(max, prices[i]);
            right[i] = Math.max(max-prices[i], right[i+1]);
        }
    }


    public static void main(String[] args){
        BestTimeToBuyAndSellStockIII_H problem = new BestTimeToBuyAndSellStockIII_H();
        System.out.println(problem.maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }

}
