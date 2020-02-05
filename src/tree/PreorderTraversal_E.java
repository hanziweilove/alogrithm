package tree;

/**
 * Created by ziweihan on 5/19/19.
 * root -> left child-> right child
 *
 */
public class PreorderTraversal_E {

    public void preorderTraversal_recursively(TreeNode root) {
        if (root == null) {
            return;
        }

        processNode(root);
        preorderTraversal_recursively(root.left);
        preorderTraversal_recursively(root.right);

    }


    public void processNode(TreeNode node) {
        System.out.println(node.val);
    }


    public static void main(String[] args) {
        PreorderTraversal_E problem = new PreorderTraversal_E();
        TreeNode root = BST.createBST();
        problem.preorderTraversal_recursively(root);
    }
}
