package array;

/**
 * Created by ziweihan on 2/5/20.
 *
 * 75. Sort Colors
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same
 * color are adjacent, with the colors in the order red, white and blue.
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 Note: You are not suppose to use the library's sort function for this problem.

 Example:
 Input: [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]
 Follow up:

 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
 then 1's and followed by 2's.
 Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors_M {

    /**
     * Using two pointers, start is used for red(0), end is used for blue(b).
     * once we see 0, we set nums[start] = 0, and swap num[start] with num[i]
     * once we see 2, we set nums[end] = 2, and swap num[end] with num[i]
     * The trick is, when i>end we should stop the loop,
     * otherwise numbers will be swapped to wrong index again, since end could be now at a 1 position.
     * @param nums
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length<=1) return;

        int start = 0; //index for where 0 should go
        int end = nums.length-1;  //index for where 2 should go
        int i = 0; //index of current element

        //notice the loop condition when to stop
        while(i<=end){
            if(nums[i] == 0){
                nums[i] = nums[start];
                nums[start] = 0;
                start++;
                i++;
            }else if(nums[i] == 2){
                nums[i] = nums[end];
                nums[end] = 2;
                end --;
                // don't increment i here because nums[i] could be 0 or 1,
                // which needs to be swapped again.
            }else{
                i ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,0,1};
        SortColors_M solution = new SortColors_M();
        solution.sortColors(input);
        int i = 0;
        while(i<input.length){
            System.out.println(input[i++]);
        }
    }
}
