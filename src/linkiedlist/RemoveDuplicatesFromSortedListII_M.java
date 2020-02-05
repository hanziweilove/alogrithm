package linkiedlist;

/**
 * Created by ziweihan on 8/2/19.
 *
 * 82. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.

 Example 1:

 Input: 1->2->3->3->4->4->5
 Output: 1->2->5
 Example 2:

 Input: 1->1->1->2->3
 Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII_M {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode curNew = newHead;
        ListNode cur = head;
        boolean isDup;

        while(cur != null){
            isDup = false;
            while(cur.next != null && cur.val == cur.next.val){
                // have to check cur.next nullability because
                // we need to compare cur and cur.next
                cur = cur.next;
                isDup = true;
            }
            // only append distinct node to new list
            if(!isDup){
                curNew.next = cur;
                curNew = curNew.next;
            }
            cur = cur.next;
        }
        // set the next of the new list to null,
        // otherwise the given list will be connected to new list with dup items in the last
        curNew.next = null;

        return newHead.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
//        node2.next =  node3;
//        node3.next = null;

        RemoveDuplicatesFromSortedListII_M problem = new RemoveDuplicatesFromSortedListII_M();
        ListNode newHead = problem.deleteDuplicates(head);

    }
}
