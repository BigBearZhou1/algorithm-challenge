package leetcode.offer.week4.day02;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class SubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean isSubTree(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
    }
}
