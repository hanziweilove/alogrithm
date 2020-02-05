package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ziweihan on 5/19/19.
 * 94. Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Left --> Root--> Right
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class InorderTraversal_E {

    /**
     * 1. Stack
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (true) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                result.add(curNode.val);
                curNode = curNode.right;
            } else {
                //done with the tree, exit outer while loop
                break;
            }
        }
        return result;
    }


    /**
     * 2. Recursion： left child, root, right child
     * @param root
     */
    public void inorderTraversal_recursively(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal_recursively(root.left);
        processNode(root);
        inorderTraversal_recursively(root.right);

    }

    public void processNode(TreeNode node) {
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        InorderTraversal_E problem = new InorderTraversal_E();
        TreeNode root = BST.createBST();
        problem.inorderTraversal(root);
    }


}
