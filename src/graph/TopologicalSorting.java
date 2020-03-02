package graph;

import java.util.*;

/**
 * Created by ziweihan on 2/27/20.
 * LintCode
 * 127. Topological Sorting
 Given an directed graph, a topological order of the graph nodes is defined as follow:

 For each directed edge A -> B in graph, A must before B in the order list.
 The first node in the order can be any node in the graph with no nodes direct to it.
 Find any topological order for the given graph.

 Example
 For graph as follow:
 The topological order can be:

 [0, 1, 2, 3, 4, 5]
 [0, 2, 3, 1, 5, 4]
 ...
 Challenge
 Can you do it in both BFS and DFS?
 */


public class TopologicalSorting {

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> map = new HashMap<>();

        //mark visited node in the map
        for(DirectedGraphNode node: graph){
            for(DirectedGraphNode neighbor: node.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, 1);
                }else{
                    map.put(neighbor, map.get(neighbor)+1);
                }
            }
        }

        //mark unvisited nodes in the res and queue.
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node: graph){
            if(!map.containsKey(node)){
                res.add(node);
                queue.offer(node);
            }
        }

        //polling from the queue and find the order list
        while(!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for(DirectedGraphNode neighbor: node.neighbors){
                map.put(neighbor, map.get(neighbor)-1);
                if(map.get(neighbor) ==0){
                    res.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {


    }
}
