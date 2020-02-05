package tree;

/**
 * Created by ziweihan on 7/24/19.
 *
 * 701. Insert into a Binary Search Tree
 *
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree,
 * insert the value into the BST. Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.

 Note that there may exist multiple valid ways for the insertion, as long as the tree
 remains a BST after insertion.
 You can return any of them.

 For example,
 Given the tree:
  4
 / \
 2   7
 / \
 1   3
 And the value to insert: 5
 You can return this binary search tree:

    4
  /   \
 2     7
 / \   /
 1   3 5
 This tree is also valid:

     5
   /   \
  2     7
 / \
 1   3
 \
 4
 */
public class InsertIntoBST_M {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode parent = root;
        while(node != null){
            parent = node;
            if(val<node.val){
                node = node.left;
            } else if(val>node.val){
                node = node.right;
            }
        }
        //now parent is the last visited node;
        if(val<parent.val){
            //add to the left child of last visited parent
            parent.left = new TreeNode(val);
        }else {
            //add to the right child of last visited parent
            parent.right = new TreeNode(val);
        }
        return root;
    }

    public static void main(String[] args){
        InsertIntoBST_M problem = new InsertIntoBST_M();
        TreeNode root = BST.createBST();
        problem.insertIntoBST(root, 12);

    }
}
