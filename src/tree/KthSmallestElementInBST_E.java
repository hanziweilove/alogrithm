package tree;

/**
 * Created by ziweihan on 5/29/19.
 *
 * 230. Kth Smallest Element in a BST
 *
 * Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Example 1:

 Input: root = [3,1,4,null,2], k = 1
    3
   / \
  1   4
   \
   2
 Output: 1
 Example 2:

 Input: root = [5,3,6,2,4,null,null,1], k = 3
      5
     / \
    3   6
   / \
  2   4
 /
 1
 Output: 3
 Follow up:
 What if the BST is modified (insert/delete operations) often and
 you need to find the kth smallest frequently?
 How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInBST_E {
    int count = 1;
    int result;


    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;

        kthSmallest(root.left, k);
        if(k==count)
            result = root.val;
        count++;
        kthSmallest(root.right, k);
        return result;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.setLeft(left);
        root.setRight(right);
        left.setRight(new TreeNode(2));

        KthSmallestElementInBST_E problem = new KthSmallestElementInBST_E();
        System.out.print(problem.kthSmallest(root, 2));
    }

}
