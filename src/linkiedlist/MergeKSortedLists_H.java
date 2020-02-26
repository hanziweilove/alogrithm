package linkiedlist;

/**
 * Created by ziweihan on 2/19/20.
 *
 * 23. Merge k Sorted Lists *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_H {

    /**
     * Using priority queue to offer first available element in each list, then poll the next smallest element and put
     * it into the result list.
          1->4->5,
          1->3->4,
          2->6
     first offer 1,1,2 into the queue, then queue polling 1 out of the queue, then we put 1.next into the queue which is
     node 4 into the queue.
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        //define a comparator to avoid ClassCastException: linkiedlist.ListNode cannot be cast to java.lang.Comparable
        Comparator<ListNode> comparator = (ListNode o1, ListNode o2)-> o1.val -o2.val;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
        for(ListNode node: lists){
            if(node != null)
                queue.offer(node);
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            cur.next = new ListNode(node.val); //add the next small element into the result list
            cur = cur.next; //advance cur node to the next node
            node = node.next; //advance node to become the next candidate into the queue.
            if(node != null){
                queue.offer(node);
            }
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(5);

        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);

        ListNode root3 = new ListNode(2);
        root3.next = new ListNode(6);

        //ListNode[] lists = new ListNode[]{null, null, null};// edge case
        ListNode[] lists = new ListNode[]{root1, root2, root3};
        MergeKSortedLists_H solution = new MergeKSortedLists_H();
        ListNode node = solution.mergeKLists(lists);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}



