package Uber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ziweihan on 5/7/19.
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class TwoSum_E {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                result[0] = map.get(diff);
                result[1] = i;
                return result;
            }else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum_E twoSum = new TwoSum_E();
        int[] result = twoSum.twoSum(new int[]{1, 2, 3}, 4);
        System.out.print(Arrays.toString(result));
//        int[] result2 = new int[2];
//        int[] result3 = {1,2,3};

    }

}
