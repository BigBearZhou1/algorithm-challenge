package dp;

/**
 * 背包问题动态规划版
 */
public class KnapsackDP {
    public int maxValue(int[] weights, int[] values, int bag) {
        int n = weights.length;
        int[][] dp = new int[n + 1][bag];

        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = -1;
                if (rest - weights[index] >= 0) {
                    p2 = dp[index + 1][rest - weights[index]] + values[index];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag - 1];
    }
}
