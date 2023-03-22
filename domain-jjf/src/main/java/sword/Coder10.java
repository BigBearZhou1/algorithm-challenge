package sword;

/**
 10- II. 青蛙跳台阶问题
 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 */
public class Coder10 {
    public static void main(String[] args) {
        System.out.println(numWays(10));
    }

    public static int numWays(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int sum_i_1 = 2;
            int sum_i_2 = 1;
            for (int i=3;i<=n;i++) {
                int tem = sum_i_1 + sum_i_2;
                sum_i_2 = sum_i_1;
                sum_i_1 = tem % 1000000007;
            }
            return sum_i_1;
        }
    }
}
