import java.util.HashMap;
import java.util.Map;

/**
 * Created by ziweihan on 6/26/19.
 *
 * Uber phone interview
 * class Node{
    int key;
    int value;
    Node pre;
    Node next;

 public Node(int key, int value) {
 this.key = key;
 this.value = value;
 }
 }
 */
interface Cache<K, V> {
    void put(K key, V value);
    V get(K key);
}

public class LRUCache_generics implements Cache<Integer, Integer>{

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int cap;

    public LRUCache_generics(int cap) {
        this.cap = cap;
        this.map = new HashMap<>();
    }

    @Override
    public void put(Integer key, Integer value) {
        //exists case
        if(map.containsKey(key)){
            //update the value for the key
            Node node = map.get(key);
            node.value = value;
            remove(node);
            offer(node);
        }else {
            Node node = new Node(key, value);
            //exceeding cap, remove head.
            if(map.entrySet().size() == cap){
                //removal order matters, have to remove from map first
                map.remove(head.key);
                remove(head);
            }
            offer(node);
            map.put(key, node);
        }

    }

    @Override
    public Integer get(Integer key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            //though it's removed, but we still want to keep it in the cache.
            offer(node);
        }
        return -1;
    }


    private void remove(Node node){
        //update pre pointer
        if(node.pre != null) {
            node.pre.next = node.next;
        }else{
            head = node.next;
        }

        //update next pointer
        if(node.next != null) {
            node.next.pre = node.pre;
        }else {
            tail = node.pre;
        }
    }

    private void offer(Node node){
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


}
