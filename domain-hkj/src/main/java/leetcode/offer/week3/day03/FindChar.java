package leetcode.offer.week3.day03;

import java.util.HashMap;
import java.util.Map;

public class FindChar {

    public static void main(String[] args) {
        System.out.println(new FindChar().firstUniqChar("leetcode"));
    }

    public char firstUniqChar(String s) {

        int n = s.length();
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (; i < n; i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c,  0);
            map.put(c, map.get(c)+1);
        }
        for (int t = 0; t < n; t++) {
            if (map.get(s.charAt(t))== 1) {
                return s.charAt(t);
            }
        }
        return ' ';

    }
    public char firstUniqCharII(String s) {

        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        return first == n ? ' ' : s.charAt(first);
    }
}
