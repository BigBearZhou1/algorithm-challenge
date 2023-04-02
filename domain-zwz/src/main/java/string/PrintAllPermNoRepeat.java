package string;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermNoRepeat {
    public List<String> printAllPermNoRepeat(String str) {
        List<String> ans = new ArrayList<>();
        process(0, str.toCharArray(), ans);
        return ans;
    }

    public void process(int i, char[] chars, List<String> ans) {
        if (i == chars.length) {
            ans.add(String.valueOf(chars));
            return;
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < chars.length; j++) {
            if (!visit[chars[j] - 'a']) {
                swap(chars, i, j);
                process(i + 1, chars, ans);
                swap(chars, i, j);
                visit[chars[j] - 'a'] = true;
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
