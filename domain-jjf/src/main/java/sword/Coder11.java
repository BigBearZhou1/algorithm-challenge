package sword;

import java.util.HashMap;
import java.util.Map;

/**
 14. 字符串中的变位词
 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 adc"
 "dcda"
 "trinitrophenylmethylnitramine"
 "dinitrophenylhydrazinetrinitrophenylmethylnitramine"
 */
public class Coder11 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (null == s1 || s2 == null || s2.length() < s1.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i ++) {
            count[s1.charAt(i) - 'a']--;
            count[s2.charAt(i) - 'a']++;
        }

        int diffCount = 0;
        for (int i = 0; i < 26; i ++) {
            if (count[i] != 0) {
                diffCount ++;
            }
        }

        if (diffCount == 0) {
            return true;
        }

        int len = s1.length();
        for (int i = 1; i < s2.length() - s1.length() + 1; i ++) {
            char c2 = s2.charAt(i - 1);
            char c2Add = s2.charAt(i + len -1);
            if (c2 == c2Add) {
                continue;
            }
            count[c2Add - 'a']++;
            count[c2 - 'a'] --;
            if (count[c2Add - 'a'] == 0) {
                diffCount --;
            } else if (count[c2Add - 'a'] - 1 == 0){
                diffCount ++;
            }

            if (count[c2 - 'a'] == 0) {
                diffCount --;
            } else if (count[c2 - 'a'] + 1 == 0) {
                diffCount ++;
            }

            if (diffCount == 0) {
                return true;
            }
        }

        return false;
    }



}
