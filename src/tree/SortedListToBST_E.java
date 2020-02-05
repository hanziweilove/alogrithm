package tree;

import linkiedlist.ListNode;

/**
 * Created by ziweihan on 5/31/19.
 *
 * 109. Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the
 two subtrees of every node never differ by more than 1.

 Example:

 Given the sorted linked list: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

        0
       / \
     -3   9
     /   /
    -10  5
 */
public class SortedListToBST_E {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);

    }

    public TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head, slow);
        node.right = sortedListToBST(slow.next, tail);
        return node;

    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(6);

        SortedListToBST_E problem = new SortedListToBST_E();
        problem .sortedListToBST(head);
    }
}
