package leetcode.LeetCode75.ArrayAndString.week02.day03;

import java.util.Arrays;

public class Product {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] seq = new int[n];
        int[] seqT = new int[n];
        seq[0] = 1;
        seqT[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            seq[i] = nums[i-1] * seq[i-1];
        }
        System.out.println(Arrays.toString(seq));
        for (int i = n - 2; i >= 0; i--) {
            seqT[i] = nums[i+1] * seqT[i+1];
        }
        System.out.println(Arrays.toString(seqT));
        for (int i = 0; i < n; i++) {
            ans[i] = seq[i] * seqT[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Product product = new Product();
        System.out.println(Arrays.toString(product.productExceptSelf(new int[]{1, 2, 3, 4})));
    }

}
