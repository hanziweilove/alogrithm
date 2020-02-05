package linkiedlist;

/**
 * Created by ziweihan on 1/22/20.
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

 You may not modify the values in the list's nodes, only nodes itself may be changed.
 Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs_M {

    public ListNode swapPairs(ListNode head) {
        if(head==null ||head.next==null) return head;

        ListNode newHead = new ListNode(0);
        newHead.next=head;

        ListNode p1=newHead;
        ListNode p2=p1.next;
        ListNode nextNode;

        while(p2!=null && p2.next!=null){
            nextNode=p2.next.next;
            p1.next=p2.next;
            p2.next.next=p2;
            p2.next=nextNode;
            p1=p2;
            p2=p2.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        SwapNodesInPairs_M pro = new SwapNodesInPairs_M();
        pro.swapPairs(head);
    }
}
