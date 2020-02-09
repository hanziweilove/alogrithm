package tree;

/**
 * Created by ziweihan on 2/8/20.
 *
 * Depth First Traversals:
 (a) Inorder (Left, Root, Right)
 (b) Preorder (Root, Left, Right)
 (c) Postorder (Left, Right, Root)
 */
public class PostOrderTraversal {

    public void postOrderTraversal_recursive(TreeNode root){
        if(root == null)
            return;

        postOrderTraversal_recursive(root.left);
        postOrderTraversal_recursive(root.right);
        processNode(root);
    }

    private void processNode(TreeNode node){
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        PostOrderTraversal solution = new PostOrderTraversal();
        solution.postOrderTraversal_recursive(BST.createBST());
    }
}
