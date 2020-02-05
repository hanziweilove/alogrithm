package linkiedlist;

/**
 * Created by ziweihan on 5/11/19.
 *
 * 206. Reverse Linked List
 *
 * Reverse a singly linked list.

 Example:
 Input: 1->2->3->4->5->NULL
 Output: 5->4->3->2->1->NULL

 Follow up:
 A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList_E {

     //Iterative
    public ListNode reverseList(ListNode head) {
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


    //Recursive
    public ListNode reverseList_resursion(ListNode head){
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur){
        if(cur == null)
            return pre;
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;

        return reverse(pre, cur);
    }

    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ReverseLinkedList_E reverseLinkedList = new ReverseLinkedList_E();
        ListNode newNode = reverseLinkedList.reverseList(head);
        ListNode.traverse(newNode);
    }
}
