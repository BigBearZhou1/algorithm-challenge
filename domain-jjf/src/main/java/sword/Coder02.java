package sword;

import java.util.HashMap;

/**
 3. 无重复字符的最长子串
 示例1
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

public class Coder02 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> charPosMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int start = 0;
        int end;
        for (int i = 0; i < chars.length; i ++) {
            char c = chars[i];
            end = i;
            if (!charPosMap.containsKey(c) || start > charPosMap.get(c)) {
                charPosMap.put(c, i);
            } else {
                start = charPosMap.get(c) + 1;
                charPosMap.put(c, i);
            }
            max = Math.max(end - start + 1, max);
        }

        return max;
    }
}
