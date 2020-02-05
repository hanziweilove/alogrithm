package linkiedlist;

/**
 * Created by ziweihan on 8/2/19.
 *
 * 92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in one-pass.

 Note: 1 ≤ m ≤ n ≤ length of list.

 Example:
 Input: 1->2->3->4->5->NULL, m = 2, n = 4
 Output: 1->4->3->2->5->NULL

 */
public class ReverseLinkedListII_M {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = head;
        ListNode pre = newHead; //the node before m

        int count = 1;
        while(count<m){
            pre = cur;
            cur = cur.next;
            count++;
        }
        ListNode end = cur; //the end node of the reversed list (node 2)

        //reverse list now
        ListNode start = null; // dumnmy pre node for reverse
        ListNode next; // n+1 node for later connection
        while(count<=n){
            next = cur.next;
            cur.next = start;
            start = cur;
            cur = next;
            count++;
        }

        //connect the head, pre = 1, start = 4
        pre.next = start;

        //connect the tail , cur = 5
        end.next = cur;

        return newHead.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ReverseLinkedListII_M problem = new ReverseLinkedListII_M();
        problem.reverseBetween(l1, 2, 4);

    }
}
