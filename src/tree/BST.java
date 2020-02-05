package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ziweihan on 3/24/19.
 *
 *                 10
 *             8        19
 *           5,9     null, 24
 *
 */
public class BST {

    public static TreeNode createBST() {

        TreeNode root = new TreeNode(10);
        root.setParent(null);
        root.setLeft(new TreeNode(8));
        root.setRight(new TreeNode(19));

        TreeNode left1 = root.getLeft();
        TreeNode right1 = root.getRight();
        left1.setParent(root);
        right1.setParent(root);

        TreeNode left1Child1 = new TreeNode(5);
        TreeNode left1Child2 = new TreeNode(9);
        left1.setLeft(left1Child1);
        left1.setRight(left1Child2);
        left1Child1.setParent(left1);
        left1Child2.setParent(left1);

        TreeNode right1Child2 = new TreeNode(24);
        right1.setRight(right1Child2);
        right1Child2.setParent(right1);

        return root;
    }

    public static int numLeafCount(TreeNode node) {
        // base case: null
        if (node == null)
            return 0;
        // base case: leaf node
        if (node.left == null && node.right == null)
            return 1;

        return numLeafCount(node.left) + numLeafCount(node.right);
    }

    public static int treeSum(TreeNode node) {
        if (node == null)
            return 0;

        return treeSum(node.left) + treeSum(node.right) + node.val;
    }

    public static TreeNode findClosestCommonParent(TreeNode node1, TreeNode node2) {
        Set<TreeNode> parentSet = new HashSet<>();
        parentSet.add(node1);
        parentSet.add(node2);

        while (node1 != null || node2 != null) {
            if (node1 != null) {
                node1 = node1.parent;
                if (parentSet.contains(node1)) {
                    return node1;
                }
                parentSet.add(node1);
            }
            if (node2 != null) {
                node2 = node2.parent;
                if (parentSet.contains(node2)) {
                    return node2;
                }
                parentSet.add(node2);
            }
        }
        return null;
    }

    public static TreeNode findCommonParent(TreeNode node1, TreeNode node2) {
        Set<TreeNode> parentSet = new HashSet<>();
        return findCommonParentRecursively(parentSet, node1, node2);
    }

    public static TreeNode findCommonParentRecursively(Set<TreeNode> set, TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null)
            return null;

        if(set.contains(node1)){
            return node1;
        }

        if(node1 != null) {
            set.add(node1);
            node1 = node1.parent;
        }

        if(set.contains(node2)){
            return node2;
        }

        if(node2 != null) {
            set.add(node2);
            node2 = node2.parent;
        }

        return findCommonParentRecursively(set, node1, node2);
    }


    public static TreeNode inOrderTraversal(TreeNode root, TreeNode target1, TreeNode target2) {
        if (root == null)
            return null;
        if (root.val == target1.val || root.val == target2.val)
            return root;

        TreeNode foundLeft = inOrderTraversal(root.left, target1, target2);
        TreeNode foundRight = inOrderTraversal(root.right, target1, target2);

        return (foundLeft != null && foundRight != null) ? root : null;
    }

    public static void main(String[] args) {
        TreeNode root = createBST();
        TreeNode commonParent = findCommonParent(root.left.left, root.left);
        System.out.print(commonParent != null ? commonParent.val : "Not Found");
    }

}
