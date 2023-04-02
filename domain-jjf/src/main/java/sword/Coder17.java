package sword;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 */

public class Coder17 {
    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        anagrams.forEach(e -> {
            System.out.println(e);
        });
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (null == s || null == p || p.length() > s.length()) {
            return new ArrayList<>();
        }

        int[] count = new int[26];
        
        for (int i = 0; i < p.length(); i ++) {
            count[p.charAt(i) - 'a'] ++;
            count[s.charAt(i) - 'a'] --;
        }
        
        int diff = 0;
        for (int i = 0; i < 26; i ++) {
            if (count[i] != 0) {
                diff ++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (diff == 0) {
            res.add(0);
        }
        
        for (int i = 1; i < s.length() - p.length() + 1; i ++) {
            int j = i + p.length() - 1;
            char minus = s.charAt(i - 1);
            char add = s.charAt(j);
            if (minus == add) {
                if (diff == 0) {
                    res.add(i);
                }
                continue;
            }

            count[add - 'a'] --;
            if (count[add - 'a'] == 0) {
                diff --;
            } else if (count[add - 'a'] == -1){
                diff ++;
            }

            count[minus - 'a'] ++;
            if (count[minus - 'a'] == 0) {
                diff --;
            } else if (count[minus - 'a'] == 1) {
                diff ++;
            }

            if (diff == 0) {
                res.add(i);
            }
        }
            
        return res;
    }
}
