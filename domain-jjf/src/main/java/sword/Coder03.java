package sword;

import java.util.HashSet;
import java.util.Set;

/**
 * 5. 最长回文子串
 给你一个字符串 s，找到 s 中最长的回文子串。
 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 输入：s = "babad"
 输出："bab"
 */

public class Coder03 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    //动态规划：s[i, j] = s[i]==s[j] && s[i+1][j-1]
    public static String longestPalindrome(String s) {
        if (null == s || s.length() == 0 || s.length() == 1) {
            return s;
        }

        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i ++) {
            dp[i][i] = true;
        }

        String max = s.substring(0, 1);
        for (int l = 2; l <= len; l ++) {
            for (int i = 0; i < len - l + 1; i ++) {
                if (!(chars[i] == chars[i + l - 1])) {
                    continue;
                }
                if (l == 2) {
                    dp[i][i+l-1] = true;
                }

                if (dp[i+1][i+l-2]) {
                    dp[i][i+l-1] = true;
                }

                if (dp[i][i+l-1] && l > max.length()) {
                    max = s.substring(i, i+l);
                }
            }
        }

        return max;

    }

}
