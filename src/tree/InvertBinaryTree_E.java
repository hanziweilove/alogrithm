package tree;

/**
 * Created by ziweihan on 2/8/20.
 *
 * 226. Invert Binary Tree
 * Invert a binary tree.

 Example:
 Input:

   4
 /   \
 2     7
 / \   / \
 1   3 6   9
 Output:

   4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */
public class InvertBinaryTree_E {

    /**
     * DFS method, need to call recursion function first to get the results from child nodes
     * Then return back to root.
     * This is similar to postOrderTraversal
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * Mine incorrect version that doesn't cover root has only one node return root case.
     * It passed most cases though.
     * Need someone's help
     * @param root
     * @return
     */
//    public TreeNode invertTree_mine(TreeNode root) {
//        if(root == null){
//            return null;
//        }
//
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        if(left==null && right == null){
//            return null;
//        }
//        if(left == null){
//            root.left = root.right;
//            root.right = null;
//        }
//        if(right == null){
//            root.right = root.left;
//            root.left = null;
//        }
//
//        //both left and right are not null, swap them
//        TreeNode leftTemp = root.left;
//        root.left = root.right;
//        root.right = leftTemp;
//
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;
//    }


    public static void main(String[] args) {
        TreeNode root = BST.createBST();
        InvertBinaryTree_E solution = new InvertBinaryTree_E();
        TreeNode newRoot = solution.invertTree(root);

    }
}
