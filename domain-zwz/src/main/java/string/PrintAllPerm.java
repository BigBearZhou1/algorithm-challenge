package string;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPerm {
    public List<String> printAllPerm(String str) {
        List<String> ans = new ArrayList<>();
        process(0, str.toCharArray(), ans);
        return ans;
    }

    private void process(int i, char[] chars, List<String> ans) {
        if (i == chars.length) {
            ans.add(String.valueOf(chars));
            return;
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars,i,j);
            process(i+1,chars,ans);
            swap(chars,i,j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        PrintAllPerm printAllPerm = new PrintAllPerm();
        List<String> ans = printAllPerm.printAllPerm("abc");
        System.out.println(ans);
    }
}
