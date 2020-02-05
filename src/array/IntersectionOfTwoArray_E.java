package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ziweihan on 1/18/20.
 *
 * 349. Intersection of Two Arrays
 *
 * Given two arrays, write a function to compute their intersection.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]

 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]
 Note:

 Each element in the result must be UNIQUE.
 The result can be in any order.
 */
public class IntersectionOfTwoArray_E {

    /**
     * Returns the unique array of two intersections, using HashSet.
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        //Traverse nums1, put unique num into Set
        for(int num : nums1){
            if(!set.contains(num)){
                set.add(num);
            }
        }

        //Traverse nums2, if a key is found, put result in the result list, then remove the key.
        List<Integer> resList = new ArrayList<>();
        for(int i = 0; i< nums2.length; i++){
            int num = nums2[i];
            if(set.contains(num)){
                resList.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[resList.size()];
        for(int i = 0; i<resList.size(); i++){
            res[i] = resList.get(i);
        }

        return res;
    }
}
