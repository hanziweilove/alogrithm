package array;

/**
 * Created by ziweihan on 5/13/19.
 *
 * 283. Move Zeroes
 Given an array nums, write a function to move all 0's to the end of it
 while maintaining the relative order of the non-zero elements.

 Example:

 Input: [0,1,0,3,12]  : 1--> index 0, 3--> index1, 12--> index 2
 Output: [1,3,12,0,0]
 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class MoveZeros_E {

    public void moveZeroes(int[] nums) {
         int count= 0;
         for(int i = 0; i < nums.length; i++){
             if(nums[i] != 0){
                 // move the non-zero number to the proper index position
                 nums[count++] = nums[i];
             }
         }

         // reset the rest of the array to 0 starting from count
        for(int i = count; i< nums.length; i++){
             nums[i] = 0;
        }

    }

    public static void main(String[] args){
        int[] input = {0,1,0,3,12};
        MoveZeros_E moveZeros = new MoveZeros_E();
        moveZeros.moveZeroes(input);
    }
}
