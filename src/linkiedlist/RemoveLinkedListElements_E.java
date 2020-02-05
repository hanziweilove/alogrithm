package linkiedlist;

/**
 * Created by ziweihan on 8/9/19.
 *
 * 203. Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value
 * val.

 Example:

 Input:  1->2->6->3->4->5->6, val = 6
 Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements_E {

    // My solution to use pre pointer.
    // pre.next = cur.next to remove cur
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1); //dummy head for the result
        ListNode pre = newHead;
        pre.next = head; //link pre to the head of the original list
        ListNode cur = head;
        while(cur != null) {
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }

        return newHead.next;
    }

    //Online solution that move the next val into cur val
//    public ListNode removeElements(ListNode head, int val) {
//        ListNode newHead = new ListNode(-1);
//        newHead.next = head;
//        ListNode cur = newHead;
//
//        while(cur.next != null){
//            if(cur.next.val == val){
//                //remove next node
//                ListNode nextNode = cur.next.next;
//                if(nextNode != null){
//                    cur.next.val = nextNode.val;
//                    cur.next.next = nextNode.next;
//                }else{
//                    cur.next = null;
//                }
//            }else {
//                cur = cur.next;
//            }
//        }
//        return newHead.next;
//    }


    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveLinkedListElements_E problem = new RemoveLinkedListElements_E();
        ListNode newNode = problem.removeElements(head, 1);
        while(newNode != null){
            System.out.println(newNode.val);
            newNode = newNode.next;
        }

    }
}
