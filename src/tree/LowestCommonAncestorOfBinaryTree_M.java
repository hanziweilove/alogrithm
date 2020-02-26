package tree;

import java.util.*;

/**
 * Created by ziweihan on 6/5/19.
 *
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

 Example 1:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 Output: 3
 Explanation: The LCA of nodes 5 and 1 is 3.
 Example 2:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 Output: 5
 Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


 Note:

 All of the nodes' values will be unique.
 p and q are different and both values will exist in the binary tree.
 */
public class LowestCommonAncestorOfBinaryTree_M {
    /**
     * 1.Recursive way
     *  https://medium.com/algorithm-problems/lowest-common-ancestor-of-a-binary-tree-8f69531087b1
     */
    public TreeNode lowestCommonAncestor_recursion(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q){
            return root;
        }

        TreeNode leftRoot = lowestCommonAncestor_recursion(root.left, p, q);
        TreeNode rightRoot = lowestCommonAncestor_recursion(root.right, p, q);

        if(leftRoot != null && rightRoot != null){
            return root;
        }

        return leftRoot != null ? leftRoot: rightRoot;
    }

    /**
     * 2. Iterative: top down
     *
     */
    public TreeNode lowestCommonAncestor_iterative(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathPList = new ArrayList<>();
        List<TreeNode> pathQList = new ArrayList<>();

        //Find the path array list from root to p and q
        pathPList = getPathToNode(root, p, pathPList);
        pathQList = getPathToNode(root, q, pathQList);

        if(pathPList.size()>0 && pathQList.size()>0){
            int i = 0;
            while(i<pathPList.size() && i<pathQList.size()){
                if(pathPList.get(i) != pathQList.get(i)){
                    //The first mismatch is the LCA
                    return pathPList.get(i-1);
                }
                i++;
            }
            return pathPList.get(i-1);
        }
        return null;
    }

    /**
     * Recursively find the path from root to the target node
     * @param root
     * @param node
     * @param path
     * @return
     */
    public List<TreeNode> getPathToNode(TreeNode root, TreeNode node, List<TreeNode> path){
        if(root == null)
            return path;
        if(root == node) {
            path.add(node);
            return path;
        }
        path.add(root);
        if(isLeftChild(root, node)){
            return getPathToNode(root.left, node, path);
        }else {
            return getPathToNode(root.right, node, path);
        }
    }

    /**
     * Decide if the given node is in the left subtree
     * @param root
     * @param node
     * @return
     */
    public boolean isLeftChild(TreeNode root, TreeNode node){
        return isChild(root.left, node);
    }

    /**
     * Determine if the given node is a child node of a root.
     * @param root
     * @param node
     * @return
     */
    public boolean isChild(TreeNode root, TreeNode node){
        if(root == null)
            return false;
        if(root == node)
            return true;
        return isChild(root.left, node) || isChild(root.right, node);
    }

    /**
     * 3. Level order traversal and use Parent map and Parent set to find common parent
     *
     */
    public TreeNode lowestCommonAncestorParentPointer(TreeNode root, TreeNode p, TreeNode q) {
        //parent map to save <K = node, Val = parent>
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parentMap.put(root, null);
        queue.offer(root);
        while(!(parentMap.containsKey(p) && parentMap.containsKey(q))) {
            // if didn't find both p and q parent set yet, keep saving parent
            TreeNode node = queue.poll();
            if(node.left != null){
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if(node.right != null){
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        Set<TreeNode> parentSet = new HashSet<>();
        // populate the parent set for p.
        while(p != null){
            parentSet.add(p);
            p = parentMap.get(p);
        }

        //use q's parent to find a match in parent set
        while(!parentSet.contains(q)){
            q = parentMap.get(q);
        }
        return q;
    }


    // Use BST properties: Left<root<Right,
    // Traverse down from the root find which side to go by values.
    public TreeNode lowestCommonAncestorInBST(TreeNode root, TreeNode p, TreeNode q) {
          while(root != null){
              if(p.val>root.val && q.val>root.val){
                  //both nodes are on the right subtree
                  root = root.right;
              }else if(p.val<root.val && q.val<root.val){
                  //both nodes are on the left subtree
                  root = root.left;
              }else {
                  //found the common parent
                  break;
              }
          }
          return root;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);

        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        TreeNode node6  = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);

        TreeNode node0  = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);

        TreeNode node7  = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);


        root.left = node5;
        root.right = node1;
        root.left.left = node6;
        root.left.right = node2;

        root.left.right.left = node7;
        root.left.right.right = node4;

        root.right.left = node0;
        root.right.right = node8;

        LowestCommonAncestorOfBinaryTree_M problem = new LowestCommonAncestorOfBinaryTree_M();
//        TreeNode LCA =  problem.lowestCommonAncestor(root, node6, node5);
//        TreeNode LCA =  problem.lowestCommonAncestor_iterative(root, node5, node4);
        TreeNode LCA =  problem.lowestCommonAncestor_iterative(root, node5, node4);

        System.out.print(LCA.val);

    }
}
