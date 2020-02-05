package tree;

import java.util.Stack;

/**
 * Created by ziweihan on 10/7/18.
 *
 * 98. Validate Binary Search Tree
 *
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.


 Example 1:

    2
   / \
 1   3

 Input: [2,1,3]
 Output: true
 Example 2:

     5
    / \
   1   4
  / \
 3   6

 Input: [5,1,4,null,null,3,6]
 Output: false
 Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBST {

    //Special case: [10,5,15,null,null, 6, 19]
    /**
    1. Inorder recursion
    inorder traversal : leftChild, process root, rightChild
    check pre val should be <= root.val
    Not accepted solution, but it's right
    */
    private static Integer min = null;

    public boolean isValidBST_Inorder(TreeNode root) {
        if(root == null)
            return true;
        //left tree
        if(!isValidBST_Inorder(root.left)){
            return false;
        }

        //check current node is valid by comparing the val with min value
        if(min != null && root.val<= min) {
            return false;
        }
        min = root.val;

        //right tree
        if(!isValidBST_Inorder(root.right)){
            return false;
        }

        return true;
    }


    /**
     * 2. Recursion: check current node and left right children
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
       return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        //validate current node
        if(min != null && root.val<=min){
            return false;
        }
        if(max != null && root.val>=max){
            return false;
        }

        //validate left child
        if(!helper(root.left, min, root.val)){
            return false;
        }

        //validate right child
        if(!helper(root.right, root.val, max)){
            return false;
        }

        return true;
    }

    /**
     * 3. Using stack: Inorder traversal
     * @param root
     * @return
     */
    boolean isValidBST_stack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Integer min = null;
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(min != null && node.val<= min){
                    return false;
                }
                min = node.val;
                root = node.right;
            }else{
                //done with the tree, exit outer while loop
                break;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ValidateBST problem = new ValidateBST();
        TreeNode root = BST.createBST();
        System.out.print(problem.isValidBST_stack(root));
    }

}
