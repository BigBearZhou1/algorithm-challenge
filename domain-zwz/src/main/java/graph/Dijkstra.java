package graph;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 图中一个点到任意一个点的最短距离
 * 距离最小的点不断地尝试去其他点，看看能不能找到最近的点
 */
public class Dijkstra {
    public static HashMap<Node, Integer> dijkstra(Node from) {

        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);

        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);

        while (minNode != null) {
            int curDistance = distanceMap.get(minNode);
            selectedNodes.add(minNode);
            for (Edge edge : minNode.getEdges()) {
                if (!distanceMap.containsKey(edge.to)) {
                    distanceMap.put(edge.to, curDistance + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(edge.to), curDistance + edge.weight));
                }
            }
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,
                                                        HashSet<Node> selectedNodes) {
        Node minNode = null;
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node cur = entry.getKey();
            int curDistance = entry.getValue();
            if (!selectedNodes.contains(cur) && curDistance < minValue) {
                minNode = cur;
                minValue = curDistance;
            }
        }
        return minNode;
    }
}
