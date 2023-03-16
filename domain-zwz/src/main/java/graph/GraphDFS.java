package graph;

import sun.security.x509.InvalidityDateExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GraphDFS {
    public static List<List<Integer>> dfs(Node node) {
        List<List<Integer>> res = new ArrayList<>();
        process(node, new HashSet<Node>(), new ArrayList<>(), res);
        return res;
    }

    private static void process(Node node, HashSet<Node> selectedNodes, ArrayList<Integer> curRes, List<List<Integer>> res) {
        if (node.nexts.size() == 0 || selectedNodes.contains(node)) {
            ArrayList<Integer> way = new ArrayList<>(curRes);
            way.add(node.value);
            res.add(way);
            return;
        }

        selectedNodes.add(node);
        curRes.add(node.value);
        for (Node next : node.nexts) {
            process(next, selectedNodes, curRes, res);
        }
        //回溯
        curRes.remove(curRes.size() - 1);
        selectedNodes.remove(node);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.nexts = Arrays.asList(n2, n3, n4);
        n2.nexts = Arrays.asList(n3, n5);
        n3.nexts = Arrays.asList(n1, n2, n4, n5);
        n4.nexts = new ArrayList<>();
        n5.nexts = new ArrayList<>();

        List<List<Integer>> dfs = GraphDFS.dfs(n1);
        System.out.println(dfs);

    }
}
