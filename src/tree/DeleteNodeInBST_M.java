package tree;

/**
 * Created by ziweihan on 6/3/19.
 *
 * 450. Delete Node in a BST
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.

 Basically, the deletion can be divided into two stages:

 Search for a node to remove.
 If the node is found, delete the node.
 Note: Time complexity should be O(height of tree).

 Example:

 root = [5,3,6,2,4,null,7]
 key = 3

      5
     / \
    3   6
   / \   \
  2   4   7

 Given key to delete is 3. So we find the node with val 3 and delete it.

 One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

       5
      / \
     4   6
    /     \
   2       7

 Another valid answer is [5,2,6,null,4,null,7].

     5
    / \
   2   6
    \   \
    4   7
 */
public class DeleteNodeInBST_M {

    /**
     * Recursion
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key > root.val){
            // Case1: target is in the right subtree
            root.right = deleteNode(root.right, key);
        } else if(key < root.val){
            // Case2: target is in the left subtree
            root.left = deleteNode(root.left, key);
        } else{
            //Case3: key == root.val
            //if the node has both children
            //replace deleted node with min node of the RIGHT sub tree, then delete min node
            if(root.left != null && root.right != null){
                TreeNode minNode = root.right;
                while(minNode.left != null){
                    minNode = minNode.left;
                }
                root.val = minNode.val;
                //delete min node
                root.right = deleteNode(root.right, minNode.val);
            } else {
                //case 4: there is only one tree
                if(root.left != null){
                    //if right tree is null
                    root = root.left;
                }else {
                    //if left tree is null
                    root = root.right;
                }
            }
        }

        return root;
    }


    public static void main(String[] args){
        DeleteNodeInBST_M problem = new DeleteNodeInBST_M();
        TreeNode newRoot = problem.deleteNode(BST.createBST(), 10);
    }


}
