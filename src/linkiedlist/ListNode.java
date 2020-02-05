package linkiedlist;

/**
 * Created by ziweihan on 10/9/18.
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void traverse(ListNode node){
        if(node == null)
            System.out.print("input is null");

        while(node!= null){
            System.out.print(node.val + " -->");
            node = node.next;
        }
    }

}
