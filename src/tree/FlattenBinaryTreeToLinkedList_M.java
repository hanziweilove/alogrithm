package tree;

/**
 * Created by ziweihan on 6/12/19.
 *
 * 114. Flatten Binary Tree to Linked List
 Given a binary tree, flatten it to a linked list in-place.

 For example, given the following tree:

       1
      / \
     2   5
   / \   \
 3   4   6
 The flattened tree should look like:

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
 */
public class FlattenBinaryTreeToLinkedList_M {

    // use inorder traversal
    public void flatten(TreeNode root) {
        if(root == null)
            return;

        flatten(root.left);
        processNode(root);
        flatten(root.right);
    }

    private void processNode(TreeNode node){
        //case one: if root has both children
        if(node.left != null && node.right != null){
            TreeNode cur = node.left;
            TreeNode right = node.right;
            //find the tail of left child and then connect it to the original right child
            while(cur.right!= null){
                cur = cur.right;
            }
            //connect left child to right
            node.right = node.left;
            //connect original right child to the end of the left child tree list
            cur.right = right;
            //set current left child to null
            node.left = null;
        }
        //case 2: if only has left child
        else if(node.left != null){
            node.right = node.left;
            node.left = null;
        }
        //case 3: if only has right child, no need to handle
    }

    public static void main(String[] args){
        FlattenBinaryTreeToLinkedList_M problem  = new FlattenBinaryTreeToLinkedList_M();
//        TreeNode root = BST.createBST();
        //[1,2,null,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        problem.flatten(root);


    }



}
