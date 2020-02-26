package tree;

/**
 * Created by ziweihan on 7/26/19.
 *
 * 938. Range Sum of BST
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R
 * (inclusive).
 The binary search tree is guaranteed to have unique values.

 Example 1:
 Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 Output: 32

 Example 2:
 Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 Output: 23

 Note:
 The number of nodes in the tree is at most 10000.
 The final answer is guaranteed to be less than 2^31.
 */

public class RangeSumOfBST_E {

    /**
     * 1. DFS to add children nodes FIRST, that is between L and R.     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null)
            return 0;
        //recursively accumulate the left and right child sum
        int left = rangeSumBST(root.left, L, R);
        int right = rangeSumBST(root.right, L, R);
        int childSum = left + right;

        // if the node value is between the range add it up to the sum
        if(root.val>=L && root.val<=R){
            return root.val + childSum;
        }

        return childSum;
    }

    /**
     * 2. Use global var to keep track of which val to add to the sum
     */
    int sum = 0;
    public int rangeSumBST_recursive(TreeNode root, int L, int R){
        if(root == null)
            return 0;
        if(root.val>=L && root.val<=R){
            sum += root.val;
        }
        rangeSumBST_recursive(root.left, L, R);
        rangeSumBST_recursive(root.right, L, R);
        return sum;
    }
    public static void main(String[] args){
        TreeNode root = BST.createBST();
        RangeSumOfBST_E problem = new RangeSumOfBST_E();
        System.out.println(problem.rangeSumBST(root, 9,19));
    }

}
