package linkiedlist;

/**
 * Created by ziweihan on 1/22/20.
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You may not modify the values in the list's nodes, only nodes itself may be changed.

 Example 1:
 Given 1->2->3->4, reorder it to 1->4->2->3.

 Example 2:
 Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 1->2->3->4->5->6->7->8 reorder it to 1->8->2->7->3->6->4->5

 1,2,3, 4,5,6,7
 7,6,5,4

 */
public class ReorderList_M {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        //find middle of the list
        ListNode fast = head;
        ListNode slow = head;
        ListNode endNode= head;
        while(fast != null && fast.next != null){
            endNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //set the end of the first list to null
        endNode.next = null;
        //reverse second half of linked list
        slow = reverseList(slow);

        //join two lists : head and slow
        //1-2-3  head list
        //8-7-6-5 slow list
        // after merge: 1-8-2-7-3-6-4-5
        ListNode pre = null; //used to connect the odd node of the second list
        while(head != null){
            pre = slow;
            ListNode headNext = head.next;
            head.next = slow;
            ListNode slowNext = slow.next;
            slow.next = headNext;
            slow = slowNext;
            head = head.next.next;
        }

        if(slow != null){
            pre.next = slow;
        }


    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
      //  node3.next = node4;

        ReorderList_M pro = new ReorderList_M();
        pro.reorderList(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
