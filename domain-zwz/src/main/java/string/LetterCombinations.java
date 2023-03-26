package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, List<Character>> digit2Chars = new HashMap<>();
        digit2Chars.put('2', Arrays.asList('a', 'b', 'c'));
        digit2Chars.put('3', Arrays.asList('d', 'e', 'f'));
        digit2Chars.put('4', Arrays.asList('g', 'h', 'i'));
        digit2Chars.put('5', Arrays.asList('j', 'k', 'l'));
        digit2Chars.put('6', Arrays.asList('m', 'n', 'o'));
        digit2Chars.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digit2Chars.put('8', Arrays.asList('t', 'u', 'v'));
        digit2Chars.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> res = new ArrayList<>();
        process(0, digits, digit2Chars, "", res);
        return res;
    }

    private void process(int curIdx, String digits, HashMap<Character, List<Character>> digit2Chars,
                         String curRes, List<String> res) {
        if (curIdx == digits.length()) {
            res.add(curRes);
            return;
        }
        List<Character> chars = digit2Chars.get(digits.charAt(curIdx));
        for (Character aChar : chars) {
            process(curIdx + 1, digits, digit2Chars, curRes + aChar, res);
        }
    }

    public static void main(String[] args) {
        LetterCombinations solution = new LetterCombinations();
        List<String> result = solution.letterCombinations("2");
        System.out.println(result);
    }
}
