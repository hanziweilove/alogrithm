package tree;

/**
 * Created by ziweihan on 2/5/20.
 *
 * 112. Path Sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.

 Note: A leaf is a node with no children.
 Example:

 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum_E {

    /**
     * Similar problems
     * {@link PathSum_E}
     * {@link PathSum_M}
     * {@link BinaryTreePath_E}
     * {@link SumRootToLeaf_M}
     * {@link recursion.Subset_Or_Combination_M}
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        // update sum
        sum = sum-root.val;
        //found leaf node and the target sum
        if(root.left == null && root.right == null && sum ==0){
            return true;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = BST.createBST();
        PathSum_E solution = new PathSum_E();
        System.out.print(solution.hasPathSum(root, 27));
    }
}
