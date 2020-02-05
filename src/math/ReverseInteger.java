package math;

/**
 * Created by ziweihan on 5/28/19.
 * 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only store integers
 within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        // Note the condition is !=0 for negative numbers
        while(x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args){
        ReverseInteger problem = new ReverseInteger();
        System.out.print(problem.reverse(-123));
    }
}
