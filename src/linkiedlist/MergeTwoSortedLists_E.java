package linkiedlist;

/**
 * Created by ziweihan on 5/26/19.
 *
 * 21. Merge Two Sorted Lists
 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.
 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists_E {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0); // new Head of the result list for return val
        ListNode curNew = l3; //pointer for l3 to move forward

        while(l1 != null && l2 != null){ //merge two list till either is null
            if(l1.val<=l2.val){
                curNew.next = l1;
                l1 = l1.next;
            } else {
                curNew.next = l2;
                l2 = l2.next;
            }
            curNew = curNew.next;

        }

        // append the rest of the list to result for the longer list.
        if(l1 != null){
            curNew.next = l1;
        }

        if(l2 != null){
            curNew.next = l2;
        }

        return l3.next;

    }
    public static void main(String[] args){

        MergeTwoSortedLists_E problem = new MergeTwoSortedLists_E();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        problem.mergeTwoLists(l1, l2);

    }
}
