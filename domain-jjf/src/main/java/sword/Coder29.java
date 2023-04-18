package sword;

import entity.TreeNode;

/**
 * 045. 二叉树最底层最左边的值
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 */
public class Coder29 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(-1);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(5);
//        TreeNode node5 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(7);

//        node.left = node1;
//        node1.left = node2;
//        node.right = node3;
//        node3.left = node4;
//        node3.right = node5;
//        node5.left = node6;

        node.right = node1;

        System.out.println(new Coder29().findBottomLeftValue(node));
    }

    public int findBottomLeftValue(TreeNode root) {
        Node node = new Node(0, root.val);
        findLeft(0, root, node);
        findLight(0, root, node);

        return node.val;
    }

    public void findLeft(int level, TreeNode root, Node node) {
        if (null != root.left) {
            if (node.level < level + 1) {
                node.level = level + 1;
                node.val = root.left.val;
            }

            findLeft(level + 1, root.left, node);
        }

        if (null != root.right) {
            findLeft(level + 1, root.right, node);
        }
    }

    public void findLight(int level, TreeNode root, Node node) {
        if (null != root.right) {
            if (node.level < level + 1) {
                node.level = level + 1;
                node.val = root.right.val;
            }

            findLight(level + 1, root.right, node);
        }

        if (null != root.left) {
            findLight(level + 1, root.left, node);
        }
    }


    static class Node {
        int level;
        int val;

        public Node(int level, int val) {
            this.level = level;
            this.val = val;
        }
    }
}
