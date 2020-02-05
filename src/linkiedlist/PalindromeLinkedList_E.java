package linkiedlist;

import java.util.Stack;

/**
 * Created by ziweihan on 5/11/19.
 *
 Given a singly linked list, determine if it is a palindrome.

 Example 1:

 Input: 1->2
 Output: false
 Example 2:

 Input: 1->2->2->1
 Output: true
 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList_E {


    private ListNode reverseList(ListNode head){
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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //find the mid point of the list
        //reverse the second half of the list
        //compare the first half and reversed second half
        slow = reverseList(slow);
        while(slow!= null){
            if(slow.val != head.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }


//    public boolean isPalindrome(ListNode head) {
//        if(head== null || head.next == null) return true;
//        int size = findListSize(head);
//        int count = 0;
//        Stack<ListNode> stack = new Stack();
//
//        while(head != null){
//            if(count <= size/2-1){
//                // push on the stack
//                stack.push(head);
//            }
//            else {
//                if(!isMiddleElement(count, size)){
//                    //pop stack and compare
//                    if(!stack.isEmpty()){
//                        ListNode node = stack.pop();
//                        if(node.val != head.val) {
//                            return false;
//                        }
//                    }
//                }
//            }
//            count++;
//            head = head.next;
//        }
//        return true;
//    }
//
//    private boolean isMiddleElement(int count, int size){
//        return size%2 >0 && count == size/2;
//    }
//
//    private int findListSize(ListNode head){
//        int count = 0;
//        while(head != null){
//            count++;
//            head = head.next;
//        }
//        return count;
//    }

    public static void main(String[] args){
        PalindromeLinkedList_E palindromeLinkedList = new PalindromeLinkedList_E();

        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(0);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.print(palindromeLinkedList.isPalindrome(head));
    }
}
