package recursion;

import tree.BST;
import tree.TreeNode;

/**
 * Created by ziweihan on 5/8/19.
 */
public class MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);

        int max = Math.max(left_depth, right_depth)+1;

        return max;
    }


    public static void main(String[] args){
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        TreeNode root = BST.createBST();
        System.out.print(maximumDepthOfBinaryTree.maxDepth(root));

    }


}
