package tree;

/**
 * Created by ziweihan on 5/27/19.
 *
 * 101. Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

                1
               / \
              2   2
             / \ / \
            3  4 4  3
           /\ /\ /\ /\
           57 68 86 75
 But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
  \   \
  3    3
 */
public class SymmetricTree_E {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;

        if(left == null)
            return false;

        if(right == null)
            return false;

        return  left.val == right.val &&
                isSymmetric(left.right,right.left) &&
                isSymmetric(left.left, right.right);

    }


    public static void main(String[] args){
        SymmetricTree_E problem = new SymmetricTree_E();
        TreeNode root = BST.createBST();
        System.out.print(problem.isSymmetric(root));

    }
}
