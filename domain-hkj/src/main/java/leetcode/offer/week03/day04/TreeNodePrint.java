package leetcode.offer.week03.day04;


import java.util.ArrayDeque;
import java.util.ArrayList;

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


    public int[] levelOrder(TreeNode root) {
        if (root == null) return null;
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        ArrayList<Integer> temp = new ArrayList<>();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            temp.add(node.val);
            if (node.left != null) nodes.add(node.left);
            if (node.right != null) nodes.add(node.right);
        }
        int n = temp.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

}
