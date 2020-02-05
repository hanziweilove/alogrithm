package array;

import java.util.Arrays;

/**
 * Created by ziweihan on 5/14/19.
 *
 * 169. Majority Element
 Given an array of size n, find the majority element. The majority element is the element that
 appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Example 1:
 Input: [3,2,3]
 Output: 3

 Example 2:
 Input: [2,2,1,1,1,2,2]
 Output: 2


 */
public class MajorityElement_E {

    public int majorityElement(int[] nums) {
        // using Majority vote algorithm
        int count = 0;
        int majorityItem = 0;
        for(int i = 0; i< nums.length; i++){
            if(majorityItem == nums[i]){
                count++;
            }else if(count == 0){
                majorityItem = nums[i];
                count++;
            }else {
                count--;
            }
        }
        return majorityItem;
    }

    public int majorityElement_sorting(int[] nums){
        //1. search_sort and find
        Arrays.sort(nums);
        int mid = nums.length/2;

        //2. verify
        return nums[mid];

    }

    public static void main(String[] args){
            MajorityElement_E majorityElement = new MajorityElement_E();
            System.out.print(majorityElement.majorityElement_sorting(new int[]{1,2,3,2,6,2}));
    }

}
