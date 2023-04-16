package sword;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *  044. 二叉树每层的最大值
 */
public class Coder28 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2= new TreeNode(2);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(9);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.right = root5;

        List<Integer> integers = new Coder28().largestValues(root);
        integers.forEach(System.out::println);
    }

    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        add(root, 0, map);
        return new ArrayList<>(map.values());
    }

    public void add(TreeNode root, int level, Map<Integer, Integer> map) {
        if (null == root) {
            return;
        }

        if (map.containsKey(level)) {
            if (map.get(level) < root.val) {
                map.put(level, root.val);
            }
        } else {
            map.put(level, root.val);
        }

        add(root.left, level + 1, map);
        add(root.right, level + 1, map);
    }
}
