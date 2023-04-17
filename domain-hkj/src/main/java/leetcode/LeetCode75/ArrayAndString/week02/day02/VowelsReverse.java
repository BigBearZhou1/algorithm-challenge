package leetcode.LeetCode75.ArrayAndString.week02.day02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class VowelsReverse {
    public String reverseVowels(String s) {
        char[] aeiou = new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        HashSet<Character> set = new HashSet<>();
        for (Character c: aeiou) {
            set.add(c);
        }

        Stack<Character> aeiouStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                aeiouStack.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                sb.append(aeiouStack.pop());
            }else {
                sb.append(c);
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println((new VowelsReverse().reverseVowels("leetcode")));
    }
}
