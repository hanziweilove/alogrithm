package array;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ziweihan on 1/17/20.
 *
 * 373. Find K Pairs with Smallest Sums
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:

 Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 Output: [[1,2],[1,4],[1,6]]
 Explanation: The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

 Example 2:

 Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 Output: [1,1],[1,1]
 Explanation: The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

 Example 3:

 Input: nums1 = [1,2], nums2 = [3], k = 3
 Output: [1,3],[2,3]
 Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */

public class KPairsWithSmallestSum_M {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        List<List<Integer>> res = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;

        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        for(int j = 0; j< m; j++){
            pq.offer(new Tuple(0, j, nums1[0]+nums2[j]));
        }
        for(int i = 0; i< Math.min(k, m*n); i++){
            Tuple tuple = pq.poll();
            List<Integer> sumPair = new ArrayList<>();
            sumPair.add(nums1[tuple.x]);
            sumPair.add(nums2[tuple.y]);
            res.add(sumPair);

            if(tuple.x == n-1) continue;

            pq.offer(new Tuple(tuple.x+1, tuple.y, nums1[tuple.x+1]+nums2[tuple.y]));
        }
        return res;

    }

    public static void main(String[] args){
//        int[] nums1 = {1,2,3,4,5,6};
//        int[] nums2 = {3,5,7,9};

        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};

        int k = 10;
        KPairsWithSmallestSum_M problem = new KPairsWithSmallestSum_M();
        problem.kSmallestPairs(nums1,nums2,k);


    }
}
