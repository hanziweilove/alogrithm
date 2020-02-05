package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ziweihan on 5/18/19.
 *
 * 107. Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
 * level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
      3
     / \
    9  20
    /   \
  15    7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class LevelOrderTraversalII_E {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null)
            return resultList;

        // Using BFS method, null is used to identify the last item of the level.
        Queue<TreeNode> queue  = new LinkedList<>();
        // init first level and elements
        List<Integer> levelList = new ArrayList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur != null){
                // add node to the current level list
                levelList.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                // if it's the end of next level, add the current level to result.
                if(queue.peek() == null){
                    queue.offer(null);
                    resultList.add(levelList);
                }
            }else{
                // null item
                // end of current level, create a new list
                levelList = new ArrayList<>();
            }
        }

        return resultList;
    }


    public static void main(String[] args){
        LevelOrderTraversalII_E problem = new LevelOrderTraversalII_E();
        problem.levelOrderBottom(BST.createBST());

    }
}
