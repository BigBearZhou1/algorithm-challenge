package leetcode.offer.week04.day03;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeMirror {
    public TreeNode mirrorTree(TreeNode root) {
        swap(root);
        return root;
    }

    public void swap(TreeNode root) {

        if (null == root) return;
        TreeNode tempTree = root.left;

        root.left = root.right;
        root.right = tempTree;
        swap(root.left);
        swap(root.right);
    }

}
