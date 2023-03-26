package sword;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class Coder12 {

    public int maxDepth(TreeNode root) {
        if (null ==root) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftMax = 0;
        if (null != left) {
            leftMax = maxDepth(left) ;
        }

        int rightMax = 0;
        if (null != right) {
            rightMax = maxDepth(right) ;
        }

        return Math.max(leftMax, rightMax) + 1;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

