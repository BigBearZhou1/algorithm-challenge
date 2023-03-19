package sword;

import java.util.HashSet;
import java.util.Set;

/**
 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。

 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 输出: 16
 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 */
public class Coder06 {
    public static void main(String[] args) {
        System.out.println(new Coder06().maxProduct(new String[]{"a","aa","aaa","aaaa"}));

    }

    public int maxProduct(String[] words) {
        if (null == words || words.length < 2) {
            return 0;
        }

        //位运算判断存在字符
        int[] bits = new int[words.length];
        for (int i = 0; i < bits.length; i ++) {
            String word = words[i];
            Set<Character> tmpChars = new HashSet<>();
            for (int j = 0; j < word.length(); j ++ ) {
                char wc = word.charAt(j);
                if (!tmpChars.contains(wc)) {
                    bits[i] = (1 << (wc - 'a')) ^ bits[i];
                    tmpChars.add(wc);

                    //可以用 |或 	两个位都为0时，结果才为0
                }
            }
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i ++) {
            for (int j = i + 1; j < words.length; j ++) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }

    //暴力解判断存在字符，时间复杂度O(N^3)
    public int maxProduct1(String[] words) {
        if (null == words || words.length < 2) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < words.length - 1; i ++) {
            for (int j = i + 1; j < words.length; j ++) {
                String s1 = words[i];
                String s2 = words[j];
                if (!isContainChar(s1, s2)) {
                    max = Math.max(max, s1.length() * s2.length());
                }
            }
        }

        return max;


    }

    public boolean isContainChar(String s1, String s2) {
        char[] cs2 = s2.toCharArray();
        char[] cs1 = s1.toCharArray();

        Set<Character> sc = new HashSet<>();
        for (int i = 0; i < cs1.length; i ++) {
            char c = cs1[i];
            sc.add(c);
        }

        for (int i = 0; i < cs2.length; i ++) {
            if (sc.contains(cs2[i])) {
                return true;
            }
        }

        return false;
    }


}
