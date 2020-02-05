package linkiedlist;

/**
 * Created by ziweihan on 10/9/18.
 *
 * 83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 Example 1:

 Input: 1->1->2
 Output: 1->2

 Example 2:

 Input: 1->1->2->3->3
 Output: 1->2->3

 */
public class RemoveDuplicateFromSortedList_E {


    public static ListNode deleteDuplicates(ListNode head) {
        // Edge case Input: 1->null
        if(head == null || head.next == null)
            return head;


        ListNode newHead  = new ListNode(-1);
        ListNode curNew = newHead;
        ListNode cur = head;
        while(cur != null){
            while(cur.next!= null && cur.val == cur.next.val){
                //have to check cur.next nullability because we need to
                // compare cur and cur.next
                cur = cur.next;
            }
            //append distinct node to new list
            curNew.next = cur;
            //advance two lists
            curNew = curNew.next;
            cur = cur.next;

        }

        return newHead.next;
    }



    public static void main(String[] args) {
         ListNode head = new ListNode(1);
         ListNode node1 = new ListNode(1);
         ListNode node2 = new ListNode(2);
         ListNode node3 = new ListNode(3);
         head.next = node1;
         node1.next = null;
         node2.next =  node3;
         node3.next = null;

         deleteDuplicates(head);

    }
}
