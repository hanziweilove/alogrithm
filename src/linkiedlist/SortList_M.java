package linkiedlist;

/**
 * Created by ziweihan on 7/26/19.
 *
 * 148. Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.

 Example 1:
 Input: 4->2->1->3
 Output: 1->2->3->4

 Example 2:
 Input: -1->5->3->4->0
 Output: -1->0->3->4->5
 */
public class SortList_M {

    // Merge search_sort
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) // base case
            return head;

        //find the middle of the list, divide and conquer
        ListNode slow = head, fast = head;
        ListNode endOfLeft = head;
        while(fast != null && fast.next!= null){
            endOfLeft = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        endOfLeft.next = null; //end the list here so we can search_sort two lists

        //search_sort left
        ListNode L = sortList(head);
        //search_sort right
        ListNode R = sortList(slow);
        //merge two parts
        return mergeTwoLists(L, R);
    }

    /**
     * Iterative way check {@link linkiedlist.MergeTwoSortedLists_E#mergeTwoLists}
     * Recursive way of sorting to lists: slower than iterative way
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }


    public static void main(String[] args){
        ListNode head = new ListNode(9);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(12);

        SortList_M problem = new SortList_M();
        ListNode sortedHead = problem.sortList(head);
    }




}
