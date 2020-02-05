package dp;


/**
 * Created by ziweihan on 3/23/19.
 *
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.

 Example:
 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 which is more subtle.

 */
public class MaximumSubarray_E {

    // 1. using two variables
    public static int maxSubArray(int[] nums) {

        int maxSoFar = 0; //for the whole array
        int maxCurrent = 0; //for the max sub array at the current index

        for(int i = 0; i<nums.length; i++){
            maxCurrent = Math. max(maxCurrent+nums[i], nums[i]);
            maxSoFar = Math.max(maxCurrent, maxSoFar);
        }

        return maxSoFar;
    }

    // 2. using dp array
    public static int maxContigiousSubArray(int[] nums){
        int[] maxSum = new int[nums.length];

        maxSum[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i<nums.length ; i++) {
            maxSum[i] = Math.max(maxSum[i-1]+nums[i], nums[i]);
            max = Integer.max(maxSum[i],max);
        }
        return max;
    }



    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(nums));
    }
}
