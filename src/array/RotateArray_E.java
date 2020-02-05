package array;


/**
 * Created by ziweihan on 5/27/19.
 *
 * 189. Rotate Array
 * Given an array, rotate the array to the RIGHT by k steps, where k is non-negative.

 Example 1:

 Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 Example 2:

 Input: [-1,-100,3,99] and k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]
 Note:

 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 Could you do it in-place with O(1) extra space?
 */
public class RotateArray_E {
    public void leftRotate(int[] nums, int k) {
        int size = nums.length;
        //handle special case if array size is smaller than the k
        if(k>size){
            k = k%size;
        }
        reverseArray(nums, 0, k-1); //Reverse first k elements
        reverseArray(nums, k, size-1); //Reverse the rest elements
        reverseArray(nums, 0, size-1); //Reverse the entire array
    }
    public void rightRotate(int[] nums, int k){
        int size = nums.length;
        //handle special case if array size is smaller than the k
        if(k>size){
            k = k%size;
        }
        reverseArray(nums, 0, size - k - 1); //Reverse first size-k elements
        reverseArray(nums, size - k, size-1); //Reverse the rest elements
        reverseArray(nums, 0, size-1); //Reverse the entire array
    }

    public void reverseArray(int[] nums, int start, int end){
        int temp;
        while(start<end){
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args){
        RotateArray_E problem = new RotateArray_E();
        problem.rightRotate(new int[]{1,2}, 5);
    }
}
