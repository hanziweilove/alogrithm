package tree;

/**
 * Created by ziweihan on 6/3/19.
 *
 * 222. Count Complete Tree Nodes
 *
 * Note:
 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled,
 and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes
 inclusive at the last level h.

 Example:

 Input:
      1
     / \
   2   3
  / \  /
 4  5 6

 Output: 6
 */
public class CountCompleteTreeNodes_M {

    /**
     * This problem is actually counting the number of nodes in the tree
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        return countNodes(root.left)+countNodes(root.right) +1;

    }

    public static void main(String[] args){
        CountCompleteTreeNodes_M problem = new CountCompleteTreeNodes_M();
        System.out.print(problem.countNodes(BST.createBST()));
    }
}
