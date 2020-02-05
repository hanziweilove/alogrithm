package recursion;

import java.util.HashMap;

/**
 * Created by ziweihan on 3/22/19.
 */
public class ClimbStairs_E {

    private static HashMap<Integer, Integer> cache = new HashMap();

    //1. Recursion with memoization
    public static int climbStairs1(int n) {
        if(cache.containsKey(n))
            return cache.get(n);
        if(n <= 2)
            return n;

        int result =  climbStairs1(n-1) + climbStairs1(n-2);
        cache.put(n, result);
        return result;
    }

    //2. dynamic programming
    public static int climbStairs2(int n) {
        if(n<=0)
            return 1;
        if(n<=2)
            return n;

        //array to store num of steps for each n val
        int[] steps = new int[n+1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i<=n ; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }

    public static void main(String[] args) {
         System.out.print(climbStairs2(4));
    }
}
