package graph;

import java.util.*;

/**
 * 最小生成树算法-Kruskal
 * 先对边按照权重从小到大排序，使用PriorityQueue
 * 从最小边开始，检查两边node是否在一个集合里，在就跳过此边，不在就加入结果并合并两个node到一个集合
 */
public class Kruskal {

    public static Set<Edge> kruskal(Graph graph) {

        HashMap<Integer, Node> nodes = graph.getNodes();
        UnionFind unionFind = new UnionFind(new ArrayList<>(nodes.values()));

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        queue.addAll(graph.getEdges());

        Set<Edge> result = new HashSet<>();

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            Node from = edge.getFrom();
            Node to = edge.getTo();
            if (!unionFind.isSameSet(from, to)) {
                result.add(edge);
                unionFind.union(from,to);
            }
        }
        return result;
    }

    //并查集
    static class UnionFind {
        Map<Node, Node> parents = new HashMap<>();
        Map<Node, Integer> sizeMap = new HashMap<>();

        public UnionFind(List<Node> nodes) {
            for (Node node : nodes) {
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findFather(Node node) {
            Stack<Node> stack = new Stack<>();
            //如果我是我自己的父节点，就证明找父节点这件事情到头了
            while (node != parents.get(node)) {
                stack.push(node);
                node = parents.get(node);
            }
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                parents.put(node, cur);
            }
            return node;
        }

        public boolean isSameSet(Node a, Node b) {
            if (a == null || b == null) {
                return false;
            }
            Node aF = findFather(a);
            Node bF = findFather(b);
            return aF == bF;
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aF = findFather(a);
            Node bF = findFather(b);

            if (aF == bF) {
                return;
            }

            Node big = sizeMap.get(aF) > sizeMap.get(bF) ? aF : bF;
            Node small = big == aF ? bF : aF;
            parents.put(small, big);
            sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
            sizeMap.remove(small);
        }
    }
}
