package math;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ziweihan on 1/6/20.
 *
 * 202. Happy Number
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy numbers.

 Example:

 Input: 19
 Output: true
 Explanation:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */
public class HappyNumber_E {

    //Method 1:  using Set record the unique numbers
    public boolean isHappy(int n) {
        Set<Integer> numSet = new HashSet();
        while(true) {
            n = getNumSquaredSum(n);
            if(n == 1)
                return true;
            if(numSet.contains(n))
                return false;
            numSet.add(n);
        }
    }

    //Method 2: using two pointers, if two same numbers met, then it's a loop.
    public boolean isHappyNum(int n) {
        int slow = n;
        int fast = n;

        do{
          slow = getNumSquaredSum(slow);
          fast = getNumSquaredSum(getNumSquaredSum(fast));
        }while(slow != fast);

        return slow == 1;
    }


    // 18 = 1 ^2 + 8^2 = 1 + 64 = 65
    private int getNumSquaredSum(int n){
        int sum = 0;
        while(n!=0){
           sum += (n%10) * (n%10);
           n /= 10;
        }
        return sum;
    }

    public static void main(String[] args){
        HappyNumber_E problem = new HappyNumber_E();
        //System.out.println(problem.isHappy(36));
        System.out.println(problem.isHappyNum(19));
    }

}
