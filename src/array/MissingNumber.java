package array;

/**
 * Created by ziweihan on 3/31/19.
 * 268. Missing Number
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.

 Example 1:

 Input: [3,0,1]
 Output: 2
 Example 2:

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8
 Note:
 Your algorithm should run in linear runtime complexity.
 Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {

    public int missingNumber(int[] nums){
        //using math sum of : sum(1 to n) = n*(n+1)/2
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
        }

        //use expected sum - actual sum of the array elements
        return n*(n+1)/2 - sum;
    }

//    public int missingNumber(int[] nums) {
//        if(nums == null || nums.length ==0)
//            return -1;
//
//        boolean[] records = new boolean[nums.length+1];
//        for(int i = 0; i< nums.length; i++){
//            int num = nums[i];
//            records[num] = true;
//        }
//
//        for(int j =0; j<records.length; j++){
//            if(!records[j]){
//                return j;
//            }
//        }
//        return -1;
//    }


    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {0,1,2,3,5,6,8,4};
        System.out.print(missingNumber.missingNumber(nums));
    }
}
