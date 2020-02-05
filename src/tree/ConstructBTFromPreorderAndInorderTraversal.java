package tree;

/**
 * Created by ziweihan on 6/2/19.
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given

 preorder = [3,9,20,15,7]
 inorder = [9,3,15,20,7]
 Return the following binary tree:

      3
     / \
    9  20
    /   \
   15   7
 */
public class ConstructBTFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public  TreeNode buildTree(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) return null;

        int i = 0;
        for (i = iLeft; i <= iRight; ++i) {
            if (preorder[pLeft] == inorder[i]) break;
        }
        TreeNode cur = new TreeNode(preorder[pLeft]);
        cur.left = buildTree(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1);
        cur.right = buildTree(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight);
        return cur;
    }

    public static void main(String[] args){
        int[] preorder = new int[]{5,4,11,8,13,9};
        int[] inorder = new int[]{11,4,5,13,8,9};

        ConstructBTFromPreorderAndInorderTraversal problem = new ConstructBTFromPreorderAndInorderTraversal();
        problem.buildTree(preorder, inorder);
    }
}
