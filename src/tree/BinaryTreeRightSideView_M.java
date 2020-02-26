package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ziweihan on 2/7/20.
 *
 * 199. Binary Tree Right Side View
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 Example:

 Input: [1,2,3,null,5,null,4]
 Output: [1, 3, 4，6]
 Explanation:

    1            <--- 1
  /   \
  2     3         <--- 3
  \     \
  5     4       <--- 4
 /
 6              <---- 6
 */
public class BinaryTreeRightSideView_M {

    /**
     * 1. BFS with a Queue to remember the last node of each level.
     * use "null node" to separate each level.
     * The node next to the 'null node' is the right side view.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur!=null){
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                // if it's the end of current level,
                // add the current level to result.
                if(queue.peek() == null){
                    queue.offer(null);
                    res.add(cur.val);
                }
            }
        }
        return res;
    }

    /**
     * 2. DFS to do traversal root->right child->left child.
     * Add first element visited in the new level to the result.
     * @param root
     * @return
     */
    public List<Integer> rightSideView_DFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int  level){
        if(root == null)
            return;
        if(level == res.size())
            res.add(root.val);
        dfs(root.right, res, level+1);
        dfs(root.left, res, level+1);
    }


    public static void main(String[] args) {
        TreeNode root = BST.createBST();
        BinaryTreeRightSideView_M solution = new BinaryTreeRightSideView_M();
        List<Integer> list = solution.rightSideView(root);
        for(int num: list){
            System.out.println(num);
        }
    }
}
