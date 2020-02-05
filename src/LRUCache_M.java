/**
 * Created by ziweihan on 7/12/19.
 *
 * 146. LRU Cache
 * Design and implement a data structure for Least Recently Used (LRUCache_generics) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 The cache is initialized with a positive capacity.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 )

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 *
 */
import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 * Implementation is using:
 * Map to look up the Key
 * Doubly linked list to reorder the elements.*
 *
 *
 * 146. LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 it should invalidate the least recently used item before inserting a new item.

 The cache is initialized with a positive capacity.

 Follow up:
 Could you do both operations in O(1) time complexity?
 */

class Node{
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * In this solution head is the least recently used item.
 * Since we insert items from the tail.
 */
public class LRUCache_M {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int cap;

    public LRUCache_M(int capacity) {
        cap = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            offer(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            //update the value
            node.value = value;
            remove(node);
            offer(node);
        }else{
            if(map.entrySet().size()>=cap){
                //remove head to make room
                map.remove(head.key);
                remove(head);
            }
            Node node = new Node(key, value);
            offer(node);
            map.put(key, node);
        }
    }

    public void remove(Node node){
        //update pre pointer
        if(node.pre != null){
            node.pre.next = node.next;
        }else{
            head = node.next;
        }

        //update next pointer
        if(node.next != null){
            node.next.pre = node.pre;
        }else{
            tail = node.pre;
        }

    }

    /**
     * Insert itme from back of the linkedList
     * @param node
     */
    public void offer(Node node){
        //when queue is empty
        if(tail != null){
            tail.next = node;
        }
        node.pre = tail;
        node.next = null;
        tail = node;

        if(head == null){
            head = tail;
        }
    }

    public static void main(String[] args){

        LRUCache_M cache = new LRUCache_M(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

    }
}


