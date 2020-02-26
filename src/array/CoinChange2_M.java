package array;

/**
 * Created by ziweihan on 2/14/20 - 9:38 AM
 * 518. Coin Change 2
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 *
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 * Example 3:
 * Input: amount = 10, coins = [10]
 * Output: 1
 **/
public class CoinChange2_M {
    /**
     * f[i][j] = number of combinations to make up amount j with the first i types of coins.
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        return 0;
    }

    public static void main(String[] args) {

    }
}
