package leetcode.offer.week04.day01;


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
        boolean turnRight = false;
        while (!nodes.isEmpty()) {
            ArrayDeque<Integer> arch = new ArrayDeque<>();
            ArrayDeque<TreeNode> tempNodes = new ArrayDeque<>();

            while (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                if(turnRight){
                    arch.offerFirst(node.val);
                }else {
                    arch.offerLast(node.val);
                }
                if (node.left != null) tempNodes.offer(node.left);
                if (node.right != null) tempNodes.offer(node.right);
            }
            turnRight=!turnRight;
            nodes = tempNodes;
            lists.add(new ArrayList<>(arch));
        }
        return lists;
    }

}
