package tree;

/**
 * Created by ziweihan on 6/5/19.
 *
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as:

 a binary tree in which the depth of the two subtrees of every node never differ by
 more than 1.

 Example 1:

 Given the following tree [3,9,20,null,null,15,7]:

      3
     / \
    9  20
  /  \
 15   7
 Return true.

 Example 2:

 Given the following tree [1,2,2,3,3,null,null,4,4]:

         1
        / \
       2   2
     / \
    3   3
   / \
 4   4
 Return false.
 */
public class BalancedBinaryTree_E {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int heightL = getHeight(root.left);
        int heightR = getHeight(root.right);

        return Math.abs(heightL - heightR)<=1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    public int getHeight(TreeNode node){
        if(node == null)
            return 0;

        return Math.max(getHeight(node.left),getHeight(node.right))+1;

    }

    public static void main(String[] args){
        BalancedBinaryTree_E problem = new BalancedBinaryTree_E();
        System.out.print(problem.isBalanced(BST.createBST()));
    }


}
