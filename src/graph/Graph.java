package graph;

import java.util.*;

/**
 * Created by ziweihan on 4/3/19.
 */
public class Graph {
    private int size;
    private Vertex[] vertexes;
    private LinkedList<Vertex>[] adjArray;

    public Graph(int size) {
        this.size = size;
        vertexes = new Vertex[size];
        adjArray = new LinkedList[size];
        for(int i = 0; i < size; i++){
            vertexes[i] = new Vertex(i);
            adjArray[i] = new LinkedList<>();
        }

    }

    public void BFS(Vertex root){
        // create a queue to process all vertices
        Queue<Vertex> queue = new LinkedList<>();
        // create a set to mark visited
        Set<Vertex> visitedSet = new HashSet<>();

        visitedSet.add(root);
        processVertex(root);
        queue.offer(root);

        while(!queue.isEmpty()){
            Vertex current = queue.poll();
            List<Vertex> adjList = this.adjArray[current.data];
            for(Vertex adjVertex: adjList){
                if(!visitedSet.contains(adjVertex)){
                    visitedSet.add(adjVertex);
                    processVertex(adjVertex);
                    queue.offer(adjVertex);
                }
            }
        }
    }

    private void processVertex(Vertex vertex){
        System.out.println(vertex.data);
    }

    public static void main(String[] args){
        Graph graph = new Graph(6);
        graph.adjArray[0].add(graph.vertexes[1]);
        graph.adjArray[0].add(graph.vertexes[2]);
        graph.adjArray[0].add(graph.vertexes[3]);

        graph.adjArray[1].add(graph.vertexes[0]);
        graph.adjArray[1].add(graph.vertexes[3]);
        graph.adjArray[1].add(graph.vertexes[4]);

        graph.adjArray[2].add(graph.vertexes[0]);

        graph.adjArray[3].add(graph.vertexes[0]);
        graph.adjArray[3].add(graph.vertexes[1]);
        graph.adjArray[3].add(graph.vertexes[4]);
        graph.adjArray[3].add(graph.vertexes[5]);

        graph.adjArray[4].add(graph.vertexes[1]);
        graph.adjArray[4].add(graph.vertexes[3]);
        graph.adjArray[4].add(graph.vertexes[5]);

        graph.adjArray[5].add(graph.vertexes[3]);
        graph.adjArray[5].add(graph.vertexes[4]);

        graph.BFS(graph.vertexes[0]);

    }
}
