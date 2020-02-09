package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ziweihan on 2/8/20.
 *
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the
 nearest leaf node.

 Note: A leaf is a node with no children.

 Example:

 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 return its minimum depth = 2.
 */
public class MinimumDepthOfBinaryTree_E {

    /**
     * Used BFS, use a null pointer to separate each level,
     * increment level count when we process
     * the last node of each level.
     **/
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int levelCount = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                //once hits the first leaf node, return result.
                if (cur.left == null && cur.right == null) {
                    return levelCount;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                // if it's the end of current level,
                // increment the level count.
                if (queue.peek() == null) {
                    queue.offer(null);
                    levelCount++;
                }
            }
        }
        return levelCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);        MinimumDepthOfBinaryTree_E solution = new MinimumDepthOfBinaryTree_E();
        System.out.print(solution.minDepth(root));
    }
}
