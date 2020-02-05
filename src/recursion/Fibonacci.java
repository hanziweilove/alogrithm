package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ziweihan on 3/19/19.
 *
 * 509. Fibonacci Number
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), for N > 1.
 Given N, calculate F(N).



 Example 1:

 Input: 2
 Output: 1
 Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 Example 2:

 Input: 3
 Output: 2
 Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 Example 3:

 Input: 4
 Output: 3
 Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.


 Note:

 0 ≤ N ≤ 30.
 *
 */
public class Fibonacci {


    /**
     * 1. Recursion:  2^n exponential
     * @param n
     * @return
     */
    public int fib(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        return fib(n-1)+fib(n-2);
    }

    /**
     * 1.1 Recursion with cache: 2^n exponential , but saved repeated work in extra space
     */
    private static HashMap<Integer, Integer> cache = new HashMap();
    public int fib_cache(int n){
        if(cache.containsKey(n))
            return cache.get(n);

        //fib sequence 0,1,1,2,3,5
        if(n == 0)
            return 0;
        if(n ==1)
            return 1;

        int result;
        result = fib_cache(n-1) + fib_cache(n-2);
        cache.put(n, result);

        return result;
    }


    /**
     * 2. dp: time: O(n), space: O(N)
     * @param n
     * @return
     */
    public int fib_dp(int n){
        if(n<2) //n = 0; n=1
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 3. variable: time: O(N), space: constant
     * @param n
     * @return
     */
    public int fib_optimal(int n){
        if(n<2) //n=0, n=1
            return n;
        int a = 0;
        int b = 1;
        int c;
        for(int i = 2; i<=n; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Fibonacci pro = new Fibonacci();
        System.out.print(pro.fib_dp(3));



    }


}
