package recursion;

import tree.BinaryTreePath_E;
import tree.PathSum_E;
import tree.PathSum_M;
import tree.SumRootToLeaf_M;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 2/8/20.
 *
 * 78. Subsets
 * Given a set of distinct integers, nums,
 * return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.
 Example:

 Input: nums = [1,2,3]
 Output:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Subset_Or_Combination_M {

    /**
     * Similar to
     * {@link PathSum_E}
     * {@link PathSum_M}
     * {@link BinaryTreePath_E}
     * {@link SumRootToLeaf_M}
     * {@link recursion.Subset_Or_Combination_M}
     * The final sets are :
     * all combinations that excludes current item
     * all combinations that includes current item
     * [1,2,3] = combinations that excludes current item 3 -> [],[1],[2],[1,2]
     *         + combinations that includes current item 3 -> [3],[1,3],[2,3],[1,2,3]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        subsets(nums, 0, res, path);
        return res;
    }

    public void subsets(int[] nums, int i, List<List<Integer>> res, List<Integer> path){
        //base case
        if(i == nums.length){
            res.add(path);
            return;
        }
        List<Integer> pathWithCurrent = new ArrayList<>(path);
        path.add(nums[i]);

        //all combinations that excludes current item
        subsets(nums, i+1, res, new ArrayList<>(path));
        //all combinations that includes current item
        subsets(nums, i+1, res, new ArrayList<>(pathWithCurrent));
    }

    public static void main(String[] args) {

        Subset_Or_Combination_M solution = new Subset_Or_Combination_M();
        solution.subsets(new int[]{1,2,3});

    }
}
