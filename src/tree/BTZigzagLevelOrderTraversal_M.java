package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ziweihan on 6/2/19.
 *
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
     3
    / \
   9  20
   /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 */
public class BTZigzagLevelOrderTraversal_M {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> levelList = new ArrayList<>();
        int levelCount = 0;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null) {
                if(levelCount%2 == 0) {
                    //add to the end
                    levelList.add(node.val);
                }else {
                    //add from the beginning
                    levelList.add(0, node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }


                if (queue.peek() == null) {
                    queue.offer(null);
                    resultList.add(levelList);
                    levelCount++;
                    levelList = new ArrayList<>();
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args){
        BTZigzagLevelOrderTraversal_M problem = new BTZigzagLevelOrderTraversal_M();
        problem.zigzagLevelOrder(BST.createBST());
    }

}
