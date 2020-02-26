package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ziweihan on 6/2/19.
 *
 * 116. Populating Next Right Pointers in Each Node
 *
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 struct Node {
 int val;
 Node *left;
 Node *right;
 Node *next;
 }
 Populate each next pointer to point to its next right node.
 If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.
 Note:

 You may only use constant extra space.
 Recursive approach is fine, implicit stack space does not count as extra space for this problem.


 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class PopulatePointersInEachNode_M {

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node != null){
                node.next = queue.peek();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(queue.peek() == null){
                    // to separate the levels
                   queue.add(null);
                }
            }
        }

        return root;

    }

    public static void main(String[] args){
        PopulatePointersInEachNode_M problem = new PopulatePointersInEachNode_M();
        Node node3 = new Node(3, null, null, null);
        Node node4 = new Node(4, null,null, null);
        Node node5 = new Node(5, null, null, null);
        Node node6 = new Node(6, null,null, null);
        Node node1 = new Node(1, node3, node4, null);
        Node node2 = new Node(2, node5, node6,null);
        Node root = new Node(0, node1, node2, null);

        problem.connect(root);
    }

}
