package array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ziweihan on 2/5/20.
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.

 Example 1:

 Input: [3,2,1,5,6,4] and k = 2
 Output: 5
 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4
 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInUnsortedArray_M {

    public int findKthLargest_max_heap(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i< nums.length; i++){
            queue.offer(nums[i]);
        }

        int count = 0;
        k = queue.size() - k+1;
        while(!queue.isEmpty()){
            int item = queue.poll();
            count++;
            if(count == k)
                return item;

        }
        return -1;
    }

    /**
     * useing quick sort partition to find the sorted split position
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int first = 0;
        int last = nums.length-1;
        k = nums.length - k; //update k since we need to find kth largest element,
                             // here we can find kth index as the result.
        while(true){
            int sp = partition(nums, first, last);
            if(sp == k) return nums[k];
            if(sp< k)
                first = sp+1;
            else
                last = sp-1;
        }

    }


    private int partition(int[] nums, int first, int last){
        int pivot = nums[first];
        do{
            while(first<last && pivot<=nums[last]){
                last--;
            }
            if(first == last) break;
            nums[first] = nums[last];
            first++;

            while(first<last && pivot>=nums[first]){
                first++;
            }
            if(first == last) break;
            nums[last] = nums[first];

        }while(true);
        nums[first] = pivot;
        return first;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,1,5,6,4};
        int[] nums2 = new int[]{1};
        KthLargestElementInUnsortedArray_M solution = new KthLargestElementInUnsortedArray_M();
        System.out.print(solution.findKthLargest(nums1, 3));
    }
}
