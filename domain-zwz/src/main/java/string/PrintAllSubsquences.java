package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串的所有子序列
 */
public class PrintAllSubsquences {
    public List<String> subs(String s) {
        List<String> res = new ArrayList<>();
        process(0, "", s, res);
        return res;
    }

    private void process(int index, String cur, String original, List<String> res) {
        if (index == original.length()) {
            res.add(cur);
            return;
        }
        process(index + 1, cur, original, res);
        process(index + 1, cur + original.charAt(index), original, res);
    }

    public static void main(String[] args) {
        PrintAllSubsquences solution = new PrintAllSubsquences();
        List<String> res = solution.subs("abc");
        System.out.println(res);
    }
}
