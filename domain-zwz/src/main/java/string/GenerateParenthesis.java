package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 22. 括号生成
 * 只要剩余开的数量小于闭的括号数量就可以放置任意的括号都可以满足要求（但要注意开括号数量不要为零）
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        process("", n, n, res);
        return res;
    }

    private void process(String cur, int left, int right, ArrayList<String> all) {
        if (left == 0 && right == 0) {
            all.add(cur);
            return;
        }
        if (left == right) {
            process(cur + "(", left - 1, right, all);
        } else if (left < right) {
            if (left > 0) {
                process(cur + "(", left - 1, right, all);
            }
            process(cur + ")", left, right - 1, all);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis solution = new GenerateParenthesis();
        List<String> res = solution.generateParenthesis(3);
        System.out.println(res);
    }
}
