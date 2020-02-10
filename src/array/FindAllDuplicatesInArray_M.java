package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 2/9/20.
 *
 * 442. Find All Duplicates in an Array
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice
 * and others appear once.

 Find all the elements that appear twice in this array.
 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]
 */
public class FindAllDuplicatesInArray_M {

    /**
     * Similar to {@link FindAllNumbersDisappearedInArray_E}
     * 1. Swap each number to their correct position.
     * 4 should go to index 4-1 = 3
     * so swap nums[0]= 4 with nums[3]=7
     * [4, 3, 2, 7, 8, 2, 3, 1]
     * [1, 2, 3, 4, 3, 2, 7, 8]
     *
     * 2. traverse the sorted num array, and find out which one is the dup
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        for(int i = 0; i< nums.length; i++){
            int num = nums[i];
            if(num != nums[num-1]){
                swap(nums, i, num-1);
                --i;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            int num = nums[i];
            if(i+1 != num){
                res.add(num);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i , int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInArray_M solution = new FindAllDuplicatesInArray_M();
        List<Integer> res = solution.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
        for(int num: res){
            System.out.println(num);
        }
    }
}
