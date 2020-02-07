package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 2/7/20.
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.
 Find the total sum of all root-to-leaf numbers.
 Note: A leaf is a node with no children.

 Example:

 Input: [1,2,3]
 1
 / \
 2   3
 Output: 25
 Explanation:
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.
 Therefore, sum = 12 + 13 = 25.
 Example 2:

 Input: [4,9,0,5,1]
 4
 / \
 9   0
 / \
 5   1
 Output: 1026
 Explanation:
 The root-to-leaf path 4->9->5 represents the number 495.
 The root-to-leaf path 4->9->1 represents the number 491.
 The root-to-leaf path 4->0 represents the number 40.
 Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRootToLeaf_M {

    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int pathSum = 0;
        sumNumbers(root, res, pathSum);
        int sum = 0;
        for(int num : res){
            sum+=num;
        }
        return sum;
    }

    private void sumNumbers(TreeNode root, List<Integer> res, int pathSum){
        if(root == null)
            return;
        pathSum = pathSum*10 +root.val; //4—>  40+9-> 490+5
        if(root.left == null && root.right == null){
            res.add(pathSum);
            return;
        }
        sumNumbers(root.left, res, pathSum);
        sumNumbers(root.right, res, pathSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        SumRootToLeaf_M solution = new SumRootToLeaf_M();
        System.out.print(solution.sumNumbers(root));
    }
}
