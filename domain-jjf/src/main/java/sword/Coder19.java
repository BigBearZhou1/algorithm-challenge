package sword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Coder19 {
    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams((new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        lists.forEach(e -> {
            e.forEach(System.out::println);
            System.out.println("#####");
        });
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] tmp = new int[26];
            for (int j = 0; j < str.length(); j++) {
                tmp[str.charAt(j) - 'a'] += 1;
            }

            StringBuilder key = new StringBuilder();
            for (int k = 0; k < 26; k++) {
                key.append(tmp[k]).append("#");
            }

            if (map.containsKey(key.toString())) {
                map.get(key.toString()).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key.toString(), list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
