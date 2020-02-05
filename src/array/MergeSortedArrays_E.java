package array;

/**
 * Created by ziweihan on 5/26/19.
 *
 * 88. Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to
 * hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArrays_E {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // compare from last elements of the arrays and insert into nums1
        while (m > 0 && n > 0) {
            if (nums2[n - 1] > nums1[m - 1]) {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            } else {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }
        }

        //copy the rest of the elements from nums2 to nums1
        while (n > 0) {
            nums1[m + n - 1] = nums2[n - 1];
            n--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays_E problem = new MergeSortedArrays_E();
        problem.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
