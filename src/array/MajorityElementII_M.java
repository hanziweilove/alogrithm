package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 5/14/19.
 *
 * 229. Majority Element II
 Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 Note: The algorithm should run in linear time and in O(1) space.

 Example 1:

 Input: [3,2,3]
 Output: [3]
 Example 2:

 Input: [1,1,1,3,3,2,2,2]
 Output: [1,2]
 */
public class MajorityElementII_M {
    public List<Integer> majorityElement(int[] nums) {
        int majorityItem1 = 0;
        int majorityItem2 = 1;
        int count1 = 0;
        int count2 = 0;

        // using Moore vote algorithm to find the potential majority items
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == majorityItem1){
                count1++;
            } else if(nums[i] == majorityItem2){
                count2++;
            } else if(count1 == 0){
                majorityItem1 = nums[i];
                count1++;
            } else if(count2 == 0) {
                majorityItem2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;

        // verity if the occurance are >1/3
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i] == majorityItem1)
                count1++;
            if(nums[i] == majorityItem2)
                count2++;
        }

        List<Integer> majorityList = new ArrayList<>();
        if(count1 > nums.length/3)
            majorityList.add(majorityItem1);
        if(count2 > nums.length/3)
            majorityList.add(majorityItem2);

        return majorityList;

    }

    public static void main(String[] args){
        MajorityElementII_M majorityElementII = new MajorityElementII_M();
        majorityElementII.majorityElement(new int[]{1,1,1,3,3,2,2,2});
    }

}
