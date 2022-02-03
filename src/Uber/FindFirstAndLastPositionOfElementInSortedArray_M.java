package Uber;

import java.util.Arrays;

/**
 * Created by ziweihan on 10/12/18.
 * 34. Find First and Last Position of Element in Sorted Array *
 *
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example 1:
 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]

 Example 2:
 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray_M {

    public static int[] searchRange(int[] nums, int target) {
        int first = 0;
        int last = nums.length;
        int[] result = {-1, -1};
        while (first < last) {
            int mid = (first + last) / 2;
            if (nums[mid] == target) {
                //keep looking for the first target on the left
                int i = mid;
                while (i >= 0 && nums[i] == target) {
                    i--;
                }
                //first target found
                result[0] = i + 1;

                //keep looking for the last target on the right
                int j = mid;
                while (j <= nums.length - 1 && nums[j] == target) {
                    j++;
                }
                //last target found
                result[1] = j - 1;
                return result;
            }

            else if (target <= nums[mid])
                last = mid;
            else
                first = mid + 1;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {4,4,4,4};
        //corner cases
//        int[] array = {4};
//        int[] array = {1,4};

        int[] result = searchRange(array,4);
        System.out.print(Arrays.toString(result));
    }

}
