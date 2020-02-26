package tree;

/**
 * Created by ziweihan on 6/4/19.
 *
 * 543. Diameter of Binary Tree
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes
 * in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
     1
    / \
   2   3
  / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree_E {

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        int maxLeft = 0;
        int maxRight = 0;
        if(root.left != null){
            maxLeft = getHeight(root.left);
        }
        if(root.right != null){
           maxRight = getHeight(root.right);
        }
        int maxDiameter = maxLeft + maxRight;
        return Math.max(maxDiameter,Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

//    public int diameterOfBinaryTree(TreeNode root) {
//        return helper(root, 0);
//    }
//
//    private int helper(TreeNode root, int diameter){
//        if(root == null){
//            return 0;
//        }
//
//        int l_height = getHeight(root.left);
//        int r_height = getHeight(root.right);
//        int heightSum = l_height+r_height;
//        diameter =  Math.max(diameter, heightSum);
//        return Math.max(diameter, Math.max(helper(root.left, diameter), helper(root.right, diameter)));
//    }

    public int getHeight(TreeNode node){
        if(node == null)
            return 0;
        return Math.max(getHeight(node.left), getHeight(node.right))+1;
    }


    public static void main(String[] args){
        DiameterOfBinaryTree_E problem = new DiameterOfBinaryTree_E();
        System.out.print(problem.diameterOfBinaryTree(BST.createBST()));
    }
}
