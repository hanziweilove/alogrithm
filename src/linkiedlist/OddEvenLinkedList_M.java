package linkiedlist;

/**
 * Created by ziweihan on 7/31/19.
 *
 * 328. Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example 1:
 Input: 1->2->3->4->5->NULL
 Output: 1->3->5->2->4->NULL

 Example 2:
 Input: 2->1->3->5->6->4->7->NULL
 Output: 2->3->6->7->1->5->4->NULL

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...

 */
public class OddEvenLinkedList_M {

    // My solution using counter,
    // If it's even node, find the next odd node and connect to the previous odd node.
    // update all the references after each iteration

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode pre = head;
        ListNode cur = head;
        int count = 1;
        //1->  2->  3->4->5->6
        //pre  cur  oddNode
        while(cur != null){
            if(count%2 == 0){
                ListNode oddNode = cur.next;
                if(oddNode != null) {
                   ListNode oddNodeNext = oddNode.next;
                   ListNode preNext = pre.next;
                   cur.next = oddNodeNext; //connect cur node to the next node of odd node.
                   pre.next = oddNode; //connect next odd node to the previous processed odd node.
                   oddNode.next = preNext; //connect odd node next to pre node next.
                   pre = oddNode;
                }
            }else{
                cur = cur.next;
            }
            count++;

        }

        return head;

    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        OddEvenLinkedList_M problem = new OddEvenLinkedList_M();
        problem.oddEvenList(head);
    }
}
