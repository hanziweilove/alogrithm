package tree;

/**
 * Created by ziweihan on 6/10/19.
 *
 * 951. Flip Equivalent Binary Trees
 *
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

 A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

 Write a function that determines whether two binary trees are flip equivalent.
 The trees are given by root nodes root1 and root2.

 Example 1:

 Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 Output: true
 Explanation: We flipped at nodes with values 1, 3, and 5.
 */
public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root2 == null)
            return false;

        return root1.val == root2.val &&
                ((flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)) ||
                (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)));
    }

    public static void main(String[] args){
        FlipEquivalentBinaryTrees problem = new FlipEquivalentBinaryTrees();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.left = new TreeNode(3);

        System.out.print(problem.flipEquiv(root1, root2));
    }


}
