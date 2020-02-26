package graph;

import java.util.*;

/**
 * Created by ziweihan on 4/14/19.
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 Example:
 Input:
 {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

 Explanation:
 Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 Node 4's value is 4, and it has two neighbors: Node 1 and 3.

 Note:
 The number of nodes will be between 1 and 100.
 The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 You must return the copy of the given node as a reference to the cloned graph.
 */
public class CloneGraph {
    /**
     * BFS way to clone
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        Node newNode = new Node();
        newNode.val = node.val;
        newNode.neighbors = new ArrayList<>(); //init list but fill in the list later with deep copies
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>(); //keeps track of node and node's copy. k = node, v = deep copy of the node

        queue.offer(node);
        map.put(node, newNode);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(int i = 0; i< cur.neighbors.size(); i++){
                Node curNeighbor = cur.neighbors.get(i);
                if(!map.containsKey(curNeighbor)) {
                    // clone node of the current neighbor
                    Node neighborCopy = new Node();
                    neighborCopy.val = curNeighbor.val;
                    neighborCopy.neighbors = new ArrayList<>();

                    // fill in each neighbor to cur's copy in the map
                    Node curCopy = map.get(cur);
                    curCopy.neighbors.add(neighborCopy);

                    // update map and queue
                    map.put(curNeighbor,neighborCopy);
                    queue.offer(curNeighbor);
                } else {
                    // fill each neighbor right away
                    List<Node> neighbors =  map.get(cur).neighbors;
                    neighbors.add(map.get(curNeighbor));
                }
            }
        }
        return newNode;

    }

    public static void main(String[] args){

        CloneGraph graph = new CloneGraph();

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();

        List<Node> list1 = Arrays.asList(node2, node3);
        List<Node> list2 = Arrays.asList(node1);
        List<Node> list3 = Arrays.asList(node1);

        node1.val = 1;
        node1.neighbors = list1;

        node2.val = 2;
        node2.neighbors = list2;

        node3.val = 3;
        node3.neighbors = list3;

        graph.cloneGraph(node1);

    }

}
