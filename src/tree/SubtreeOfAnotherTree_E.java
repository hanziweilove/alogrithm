package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 6/4/19.
 *
 * 572. Subtree of Another Tree
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the
 * same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s
 * and all of this node's descendants. The tree s could also be considered as a subtree of itself.

 Example 1:
 Given tree s:

     3
    / \
   4   5
  / \
 1   2
 Given tree t:
     4
   / \
  1   2
 Return true, because t has the same structure and node values with a subtree of s.
 Example 2:
 Given tree s:

       3
      / \
     4   5
    / \
   1   2
  /
 0
 Given tree t:
     4
    / \
   1   2
 Return false.
 */
public class SubtreeOfAnotherTree_E {
    List<TreeNode> commonNodeList = new ArrayList<>();

    /**
     * Find all common nodes first, then find out if there is the same tree structure in the list with the given tree t.
     * Note: The tree is a Binary tree, so there might be duplicate nodes
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // corner cases
        if (s == null && t == null) {
            return true;
        } else if (s == null) {
            return false;
        } else if (t == null) {
            return false;
        }

        findNewRoot(s, t);
        if(commonNodeList.isEmpty()){
            // didn't find the common root
            return false;
        }
        for(TreeNode commonNode: commonNodeList){
            if(isSameTree(commonNode, t)){
                return true;
            }
        }
        return false;
    }

    // compare if the new trees are the same
    public boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if (s == null){
            return false;
        }
        if(t == null){
            return false;
        }
        return s.val == t.val &&
                isSameTree(s.left, t.left) &&
                isSameTree(s.right, t.right);
    }

    //Inorder traversal to find the t in s
    public void findNewRoot(TreeNode s, TreeNode target){
        if(s == null){
            return ;
        }
        if(target.val == s.val){
            commonNodeList.add(s);
        }
        findNewRoot(s.left, target);
        findNewRoot(s.right, target);
    }

    public static void main(String[] args){
        SubtreeOfAnotherTree_E problem = new SubtreeOfAnotherTree_E();
        TreeNode t = new TreeNode(8);
        t.left = new TreeNode(5);
        t.right = new TreeNode(9);
        System.out.print(problem.isSubtree(BST.createBST(), t));
    }


}
