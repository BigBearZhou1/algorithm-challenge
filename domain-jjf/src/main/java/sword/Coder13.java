package sword;

/**
 * 020. 回文子字符串的个数
 */
public class Coder13 {
    public int countSubstrings(String s) {
        if (null == s) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int[][] dp = new int[s.length()][s.length()];
        int sum = 0;
        for (int i = 0; i < s.length(); i ++) {
            dp[i][i] = 1;
            sum ++;
        }

        for (int len = 2; len < s.length() + 1; len ++) {
            for (int i = 0; i < s.length() - len + 1; i ++) {
                int left = i;
                int right = i + len - 1;

                if (s.charAt(left) != s.charAt(right)) {
                    continue;
                }

                if (len == 2) {
                    dp[left][right] = 1;
                    sum++;
                } else if (dp[left + 1][right - 1] == 1) {
                    dp[left][right] = 1;
                    sum++;
                }
            }
        }

        return sum;
    }
}
