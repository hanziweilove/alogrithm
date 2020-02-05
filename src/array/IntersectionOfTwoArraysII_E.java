package array;

import java.util.*;

/**
 * Created by ziweihan on 4/2/19.
 350. Intersection of Two Arrays II

 Given two arrays, write a function to compute their intersection.

 Example 1:
 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2,2]

 Example 2:
 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [4,9]
 Note:

 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:

 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements
 into the memory at once?
 */
public class IntersectionOfTwoArraysII_E {

    public int[] intersect(int[] nums1, int[] nums2) {
        // K = element, V = element occurrences
        Map<Integer, Integer> map = new HashMap<>();
        // traverse the first array
        for(int num1: nums1){
            //increment the occurrences of this key
            map.put(num1, map.getOrDefault(num1,0)+1);
        }

        // travers the second array
        Queue<Integer> resultQueue = new LinkedList<>();
        for(int num2:nums2){
            if(map.containsKey(num2) && map.get(num2)>0){
                // find the intersection item and put it in the result
                resultQueue.offer(num2);
                // decrement the occurrence of this key
                map.put(num2, map.get(num2)-1);
            }
        }

        int[] result = new int[resultQueue.size()];
        int i = 0;
        while(!resultQueue.isEmpty()){
            result[i++] = resultQueue.poll();
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums1 = {4,9,5,6};
        int[] nums2 = {5,9,6,9};

        IntersectionOfTwoArraysII_E intersectionOfTwoArraysII = new IntersectionOfTwoArraysII_E();
        int[] result = intersectionOfTwoArraysII.intersect(nums1, nums2);
        for(int num: result){
            System.out.print(num);
        }


    }
}
