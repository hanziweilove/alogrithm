package array;

/**
 * Created by ziweihan on 6/1/19.
 *
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 */
public class SearchInRotatedSortedArray_M {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            else {
                if (nums[start] <= nums[mid]) {
                    //first half is sorted
                    if (nums[start] <= target && target <= nums[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }

                } else {
                    //second half is sorted
                    if (nums[mid] <= target && target <= nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }

                }
            }
        }

         return -1;
    }

    public static void main(String[] args){
        SearchInRotatedSortedArray_M problem  = new SearchInRotatedSortedArray_M();
        System.out.print(problem.search(new int[]{4,5,6,7,8,9,10,11,0,1}, 1));
    }

}
