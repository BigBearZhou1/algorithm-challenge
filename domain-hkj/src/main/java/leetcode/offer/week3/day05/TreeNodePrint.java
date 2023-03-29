package leetcode.offer.week3.day05;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeNodePrint {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        ArrayDeque<TreeNode> nodes = new ArrayDeque<TreeNode>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            ArrayList<Integer> arch = new ArrayList<>();
            ArrayDeque<TreeNode> tempNodes = new ArrayDeque<>();
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                arch.add(node.val);
                if (node.left != null) tempNodes.offer(node.left);
                if (node.right != null) tempNodes.offer(node.right);
            }
            nodes = tempNodes;
            lists.add(arch);

        }

        return lists;
    }

}
