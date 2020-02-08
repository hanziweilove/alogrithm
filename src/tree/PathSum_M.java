package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 2/5/20.
 *
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 Note: A leaf is a node with no children.

 Example:

 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 Return:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSum_M {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         List<List<Integer>> res = new ArrayList<>();
         pathSum(root, sum, res, new ArrayList<>());

         return res;
    }

    /**
     * DFS method recursively to get sum of each path, then add each sum to the list
     */
    private void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> pathList) {
        if(root == null)
            return ;

        sum = sum - root.val;
        pathList.add(root.val);
        if(root.left == null && root.right == null && sum == 0){
            res.add(pathList);
            return ;
        }

        //allocate new memory location, otherwise old reference will keep appending new values during traversal.
        pathSum(root.left, sum, res, new ArrayList<>(pathList));
        pathSum(root.right, sum, res, new ArrayList<>(pathList));
    }

    public static void main(String[] args) {
        TreeNode root = BST.createBST();
        PathSum_M solution = new PathSum_M();
        solution.pathSum(root, 27);

    }
}
