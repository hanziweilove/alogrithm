package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ziweihan on 3/2/20.
 *
 * 449. Serialize and Deserialize BST
 * Serialization is the process of converting a data structure or object into a sequence of bits so that
 * it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed
 * later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
 serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized
 to a string and this string can be deserialized to the original tree structure.

 The encoded string should be as compact as possible.
 Note: Do not use class member/global/static variables to store states.
 Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeDeserializeBST_M {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "{}";

        //use array list to perform as a queue,
        //because we will do some null node removal
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        //remove null nodes from the tail of the queue.
        while(queue.get(queue.size()-1) ==null){
            queue.remove(queue.size()-1);
        }

        //build the string from the list
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for(int i = 1; i<queue.size(); i++){
            if(queue.get(i)==null){
                sb.append(",#");
            }else{
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = BST.createBST();

        SerializeDeserializeBST_M problem = new SerializeDeserializeBST_M();
        System.out.println(problem.serialize(root));

    }
}
