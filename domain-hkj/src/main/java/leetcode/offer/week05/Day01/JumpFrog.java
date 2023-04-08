package leetcode.offer.week05.Day01;

public class JumpFrog {

    public int numWays(int n) {
        int mod = 1000000007;
        int fn1 = 0, fn2 = 1;
        int res = 1;
        if (n < 2) return 1;
        for (int i = 2; i < n + 1; i++) {
            fn1 = fn2;
            fn2 = res;
            res = (fn1 + fn2)% mod;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new JumpFrog().numWays(5));
    }
}
