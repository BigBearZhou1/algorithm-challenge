package tree;

import java.util.ArrayList;
import java.util.List;

public class MaxSubBSTSize {
    public int maxSubBSTSize(Node node) {
        int size = getSubBSTSize(node);
        if (size != 0) {
            return size;
        }
        return Math.max(maxSubBSTSize(node.getLeft()), maxSubBSTSize(node.getRight()));
    }

    private int getSubBSTSize(Node node) {
        if (node == null) {
            return 0;
        }
        List<Node> arr = new ArrayList<>();
        in(arr, node);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).getValue() <= arr.get(i - 1).getValue()) {
                return 0;
            }
        }
        return arr.size();
    }

    private void in(List<Node> arr, Node node) {
        if (node == null) {
            return;
        }
        in(arr, node.getLeft());
        arr.add(node);
        in(arr, node.getRight());
    }

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node6 = new Node(6);
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);

        node4.setLeft(node2);
        node4.setRight(node6);
        node2.setLeft(node1);
        node2.setRight(node3);
        node6.setLeft(node5);
        node6.setRight(node7);

        MaxSubBSTSize maxSubBSTSize = new MaxSubBSTSize();
        int res = maxSubBSTSize.maxSubBSTSize(node4);
        System.out.println(res);
    }
}
