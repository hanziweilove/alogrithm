package tree;

/**
 * Created by ziweihan on 7/24/19.
 *
 * 979. Distribute Coins in Binary Tree
 *
 *Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

 In one move, we may choose two adjacent nodes and move one coin from one node to another.
 (The move may be from parent to child, or from child to parent.)

 Return the number of moves required to make every node have exactly one coin.
 */
public class DistributeCoinsInBT_M {

    private int totalMoves;

    public int distributeCoins(TreeNode root) {
        totalMoves = 0;
        dfs(root);
        return totalMoves;
    }

    /**
     * recursive method to determine number of moves for the given root
     * @param root
     * @return
     */
    private int dfs(TreeNode root){
        if(root == null)
            return 0;

        int leftTotal = dfs(root.left);
        int rightTotal = dfs(root.right);
        totalMoves += Math.abs(leftTotal) + Math.abs(rightTotal); // accumulate the total number of moves from left and right child.

        return (root.val - 1) + leftTotal + rightTotal;
        // (root.val - 1): number of moves needed to distribute
        // plus the sum of two children moves
    }

    public static void main(String[] args){
        DistributeCoinsInBT_M problem = new DistributeCoinsInBT_M();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        problem.distributeCoins(root);
    }
}
