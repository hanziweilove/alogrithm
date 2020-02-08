package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 2/7/20.
 *
 * 257. Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.

 Note: A leaf is a node with no children.

 Example:

 Input:

 1
 /   \
 2     3
 \
 5

 Output: ["1->2->5", "1->3"]

 Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePath_E {

    public List<String> binaryTreePaths(TreeNode root) {
         List<String> res = new ArrayList<>();
        binaryTreePath(root, res, new String());
         return res;
    }

    private void binaryTreePath(TreeNode root, List<String> res, String pathStr){
        if(root == null)
            return;
        pathStr = pathStr+root.val;
        if(root.left == null && root.right == null){
            res.add(pathStr);
            return;
        }else{
            pathStr = pathStr+"->";
        }
        binaryTreePath(root.left, res, pathStr);
        binaryTreePath(root.right, res, pathStr);
    }
    public static void main(String[] args) {

        TreeNode root = BST.createBST();

        BinaryTreePath_E solution = new BinaryTreePath_E();
        List<String> list = solution.binaryTreePaths(root);
        for(String listItem: list){
            System.out.println(listItem);
        }



    }
}
