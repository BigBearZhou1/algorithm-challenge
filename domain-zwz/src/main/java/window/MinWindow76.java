package window;

import java.util.HashMap;
import java.util.Map;

public class MinWindow76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> oriCharSizes = new HashMap<>();
        for (char c : t.toCharArray()) {
            oriCharSizes.merge(c, 1, Integer::sum);
        }
        HashMap<Character, Integer> curCharSize = new HashMap<>();
        int start = 0, end = 0, len = s.length(), min = Integer.MAX_VALUE, resL = 0, resR = 0;

        while (end < len) {
            if (oriCharSizes.containsKey(s.charAt(end))) {
                curCharSize.merge(s.charAt(end), 1, Integer::sum);
            }
            while (start <= end && checkAll(curCharSize, oriCharSizes)) {
                if (min > end - start + 1) {
                    min = end - start + 1;
                    resL = start;
                    resR = end + 1;
                }
                if (oriCharSizes.containsKey(s.charAt(start))) {
                    curCharSize.merge(s.charAt(start), 1, (c1, c2) -> c1 - c2);
                }
                start++;
            }
            end++;
        }
        return s.substring(resL, resR);
    }

    private boolean checkAll(HashMap<Character, Integer> curCharSize, HashMap<Character, Integer> oriCharSizes) {
        for (Map.Entry<Character, Integer> entry : oriCharSizes.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!curCharSize.containsKey(key) || curCharSize.get(key).compareTo(value) < 0) {
                return false;
            }
        }
        return true;
    }
}
