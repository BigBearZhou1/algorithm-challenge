package sword;

import java.util.HashSet;
import java.util.Set;

/**
 16. 不含重复字符的最长子字符串
 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 */

public class Coder09 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        int j = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;

        for (int i = 0; i < chars.length; i ++) {

            while (j < chars.length) {
                boolean add = set.add(chars[j]);
                if (!add) {
                    break;
                }
                j ++;
            }
            max = Math.max(max, j - i);
            set.remove(chars[i]);
        }

        return max;

    }

}
