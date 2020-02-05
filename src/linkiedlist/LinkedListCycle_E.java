package linkiedlist;

import java.util.LinkedList;

/**
 * Created by ziweihan on 1/22/20.
 *
 * 141. Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.

 To represent a cycle in the given linked list, we use an integer pos which
 represents the position (0-indexed) in the linked list where tail connects to.
 If pos is -1, then there is no cycle in the linked list.

 Example 1:

 Input: head = [3,2,0,-4], pos = 1
 Output: true
 Explanation: There is a cycle in the linked list, where tail connects
 to the second node.

 Example 2:

 Input: head = [1,2], pos = 0
 Output: true
 Explanation: There is a cycle in the linked list, where tail connects to the
 first node.

 Example 3:

 Input: head = [1], pos = -1
 Output: false
 Explanation: There is no cycle in the linked list.


 Follow up:

 Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycle_E {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode fast  = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        ListNode head  = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        head.next = node1;
        node1.next = node2;
        node2.next = null;

        LinkedListCycle_E pro = new LinkedListCycle_E();
        System.out.print(pro.hasCycle(head));

    }
}
