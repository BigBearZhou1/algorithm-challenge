package leetcode.offer.week04.day04;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(null == root){
            return true;
        }
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode l, TreeNode r) {
        if (null == l && null == r) return true;
        if (null == l || null == r) return false;
        return l.val == r.val && isSame(l.left, r.right) && isSame(l.right, r.left);
    }

}
