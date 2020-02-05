package linkiedlist;

/**
 * Created by ziweihan on 7/31/19.
 *
 * 19. Remove Nth Node From End of List
 *Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.

 Follow up:
 Could you do this in one pass?
 *
 */
public class RemoveNthNodeFromEndOfList_M {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //create dummy node to handel edge cases, eg. if n = 1
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        //trick is to set fast and slow to newHead,
        //handel edge cases, eg. if n = 1
        ListNode fast = newHead;
        ListNode slow = newHead;
        for(int i = 0; i<=n; i++){
            // need to create a n+1 gap, in order to remove the next node
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //Remove slow.next
        slow.next = slow.next.next;

        return newHead.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthNodeFromEndOfList_M problem = new RemoveNthNodeFromEndOfList_M();
        ListNode newHead = problem.removeNthFromEnd(head, 1);


    }


}
