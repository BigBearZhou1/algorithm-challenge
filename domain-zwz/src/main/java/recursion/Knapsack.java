package recursion;

/**
 * 背包问题
 * 给定两个长度都为N的数组weights和values
 * weight[i]和values[i]分别代表i号物品的重量和价值
 * 给定一个正数bag代表背包的容量
 * 在物品不超过这个重量的前提下，返回能装下最多的价值式多少？
 */
public class Knapsack {
    public int maxValue(int[] weights, int[] values, int bag) {
        return process(weights, values, 0, bag);
    }

    private int process(int[] weights, int[] values, int i, int rest) {
        if (rest <= 0) {
            return -1;
        }
        if (i == weights.length) {
            return 0;
        }
        int p1 = process(weights, values, i + 1, rest);
        int p2 = Integer.MIN_VALUE;
        int p2Next = process(weights, values, i + 1, rest - weights[i]);
        if (p2Next != -1) {
            p2 = values[i] + p2Next;
        }
        return Math.max(p1, p2);
    }
}
