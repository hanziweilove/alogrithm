package graph;

import java.util.List;

/**
 * Created by ziweihan on 2/27/20.
 */
public class DirectedGraphNode {
    public int val;
    public List<DirectedGraphNode> neighbors;

    public DirectedGraphNode() {}

    public DirectedGraphNode(int val,List<DirectedGraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
