package tree;

/**
 * Created by ziweihan on 5/16/19.
 *
 * 108. Convert Sorted Array to Binary Search Tree
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example:

 Given the sorted array: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

       0
      / \
    -3   9
    /   /
 -10  5

 */
public class SortedArrayToBST_E {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length-1);
    }

    private TreeNode sortedArrayToBST(int[]num, int first, int last){
        if(first>last)
            return null;
        int mid = (last + first)/2;  //Note: this is a + sign.
        TreeNode midNode = new TreeNode(num[mid]);
        midNode.left = sortedArrayToBST(num, first, mid-1);
        midNode.right = sortedArrayToBST(num, mid+1, last);
        return midNode;
    }


    public static void main(String[] args){
        SortedArrayToBST_E solution = new SortedArrayToBST_E();
        TreeNode root = solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.print(root.val);
    }




}
