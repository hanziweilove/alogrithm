package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 2/9/20.
 *
 * 448. Find All Numbers Disappeared in an Array
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 Find all the elements of [1, n] inclusive that do not appear in this array.
 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 */
public class FindAllNumbersDisappearedInArray_E {

    /**
     * Swap each number to their correct position.
     * 4 should go to index 4-1 = 3
     * so swap nums[0]= 4 with nums[3]=7
     * [4, 3, 2, 7, 8, 2, 3, 1]
     * [1, 2, 3, 4, 3, 2, 7, 8]
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //swap numbers to the correct position where it should go
        for(int i =0; i<nums.length; i++){
            int num = nums[i];
            //swap num with index num-1
            //4 is supposed to go to index 4-1 = 3
            if (num != nums[num - 1]) {
                swap(nums, i, num - 1);
                --i; //remember to decrement, so the new number is inserted to the correct position.
            }
        }

       //compare the array with correct index
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            if(i+1 != nums[i]){
                res.add(i+1);
            }
        }

        return res;

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


    public static void main(String[] args) {
        FindAllNumbersDisappearedInArray_E solution = new FindAllNumbersDisappearedInArray_E();
        List<Integer> res = solution.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for(int num: res){
            System.out.println(num);
        }

    }
}
