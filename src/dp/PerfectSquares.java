package dp;

/**
 * Created by ziweihan on 4/8/19.
 *
 * 279. Perfect Squares
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 Example 1:

 Input: n = 12
 Output: 3
 Explanation: 12 = 4 + 4 + 4.
 Example 2:

 Input: n = 13
 Output: 2
 Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {

    public int numSquares_dp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i<=n; i++) {
            int j = 1;
            int result = Integer.MAX_VALUE;
            while (i - j * j >= 0) {
                result = Math.min(result, dp[i - j * j]);
                j++;
            }
            dp[i] = result+1; // 1 is for the current j.
        }
        return dp[n];
    }

    public int numSquares_recursive(int n){
        if(n <=1)
            return n;

        int i = 1;
        int result = Integer.MAX_VALUE;
        while(n - i*i >= 0){
            result = Math.min(result, numSquares_recursive(n - i * i)+1);
            i++;
        }
        return result;
    }

    public void checkResults(int n){
        for(int i = 1; i<= n ; i++){
            int result1 = numSquares_dp(i);
            int result2 = numSquares_recursive(i);
            System.out.println("input: "+ i + ",  dp = "+ result1 + ", recursion = "+ result2);
        }
    }

    public static void main(String[] args){
        PerfectSquares perfectSquares = new PerfectSquares();
//        long current = System.currentTimeMillis();
//        int result = perfectSquares.numSquares_dp(10);
//        System.out.print("");
        perfectSquares.checkResults(10);

    }
}
