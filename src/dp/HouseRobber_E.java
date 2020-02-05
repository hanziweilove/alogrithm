package dp;

/**
 * Created by ziweihan on 1/2/20.
 *
 * 198. House Robber
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 money you can rob tonight without alerting the police.

 Example 1:

 Input: [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.
 Example 2:

 Input: [2,7,9,3,1]
 Output: 12
 Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class HouseRobber_E {

    public int rob(int[] nums) {
        //Error cases : nums is empty
        if(nums == null || nums.length == 0){
            return 0;
        }
        //Error case: nums is size 1
        if(nums.length == 1){
            return nums[0];
        }
        // dpMax[]: is to store the max robbery value to the current index,
        // eg. dpMax[2] = the max value up to house index 2 (first three houses)
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        dpMax[1] = Math.max(nums[0], nums[1]);
        int twoIndexBackMax;
        int oneIndexBackMax;

        for(int i = 2; i< nums.length; i++) {
           int current = nums[i];
           twoIndexBackMax = dpMax[i - 2]; //max of two houses back
           oneIndexBackMax = dpMax[i - 1]; //max of one house back
           // current max is the max of (current value + two houses back max), since connected house triggers the alarm
           // OR the previous max value WITHOUT adding the current value.
           dpMax[i] = Math.max(current+twoIndexBackMax,oneIndexBackMax);
        }
        return dpMax[nums.length-1];
    }

    public static void main(String[] args) {
        HouseRobber_E problem = new HouseRobber_E();
        int[] input = {2,7,9,3,1};
        int result = problem.rob(input);
        System.out.println(result);
    }


}
