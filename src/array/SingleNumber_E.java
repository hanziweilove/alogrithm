package array;

/**
 * Created by ziweihan on 5/9/19.
 Given a non-empty array of integers, every element appears twice except for one. Find that single one.

 Note:

 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example 1:

 Input: [2,2,1]
 Output: 1
 Example 2:

 Input: [4,1,2,1,2]
 Output: 4
 */
public class SingleNumber_E {

    public int singleNumber(int[] nums) {
        // use XOR operation
        if(nums == null || nums.length == 0) return -1;
        int single = nums[0];
        for(int i = 1; i< nums.length ; i++){
            single = single^nums[i];
        }
        return single;
    }

    public static void main(String[] args){
         SingleNumber_E singleNumberE = new SingleNumber_E();
         int[] input = {1,4,1,3,3};
         System.out.print(singleNumberE.singleNumber(input));
    }
}
