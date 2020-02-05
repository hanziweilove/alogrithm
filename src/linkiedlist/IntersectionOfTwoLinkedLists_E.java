package linkiedlist;

/**
 * Created by ziweihan on 5/11/19.
 *
 *160. Intersection of Two Linked Lists
 *
 Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 Output: Reference of the node with value = 2

 Input Explanation: The intersected node's value is 2
 (note that this must not be 0 if the two lists intersect).
 From the head of A, it reads as [0,9,1,2,4]. From the head of B,
 it reads as [3,2,4]. There are 3 nodes before the intersected node in A;
 There are 1 node before the intersected node in B.

 */
public class IntersectionOfTwoLinkedLists_E {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        int count1 = findListSize(headA);
        int count2 = findListSize(headB);

        if(count1 > count2){
            return _getIntersectionNode(count1-count2, headA,headB);
        }else {
            return _getIntersectionNode(count2-count1, headB, headA);
        }
    }

    private ListNode _getIntersectionNode(int diff, ListNode headLong, ListNode headShort){
        while(diff>0){
            headLong = headLong.next;
            diff--;
        }

        while(headLong != null && headShort != null){
            if(headLong == headShort) {
                return headLong;
            } else{
                headLong = headLong.next;
                headShort = headShort.next;
            }
        }

        return null;
    }

    private int findListSize(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args){
        IntersectionOfTwoLinkedLists_E palindromeLinkedList = new IntersectionOfTwoLinkedLists_E();

        ListNode head1 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode head2 = new ListNode(5);
        ListNode node2_1 = new ListNode(6);
        ListNode node2_2 = new ListNode(7);

        head2.next = node2_1;
        node2_1.next = node2_2;
        node2_2.next = node3;
        ListNode intersection = palindromeLinkedList.getIntersectionNode(head1, head2);
        System.out.print(intersection.val);


    }
}
