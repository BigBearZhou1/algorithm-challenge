package graph;

import java.util.*;

public class Prim {
    public static Set<Edge> prim(Graph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        HashSet<Node> nodeSet = new HashSet<>();
        HashSet<Edge> result = new HashSet<>();

        for (Node node : graph.nodes.values()) {
            if (!nodeSet.contains(node)) {
                nodeSet.add(node);
                queue.addAll(node.getEdges());

                while(!queue.isEmpty()){
                    Edge curEdge = queue.poll();
                    Node newNode = curEdge.getTo();
                    if(!nodeSet.contains(newNode)){
                        nodeSet.add(node);
                        result.add(curEdge);
                        queue.addAll(node.getEdges());
                    }
                }
            }
        }
        return result;
    }
}
