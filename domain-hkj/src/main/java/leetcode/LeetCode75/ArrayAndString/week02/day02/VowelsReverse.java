package leetcode.LeetCode75.ArrayAndString.week02.day02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Stack;

public class VowelsReverse {
    public String reverseVowels(String s) {
        char[] aeiou = new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        HashSet<Character> set = new HashSet<>();
        for (Character c : aeiou) {
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
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String reverseVowelsAdvance(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }


    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public String reverseWords(String s) {
        s= s.trim();
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && sb.length() != 0) {
                stack.offerLast(sb.toString());
                sb.setLength(0);
            } else if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            }
        }
        stack.offerLast(sb.toString());
        return String.join(" ", stack);
    }


    public static void main(String[] args) {
//        System.out.println((new VowelsReverse().reverseVowelsAdvance("leetcode")));
        System.out.println((new VowelsReverse().reverseWords("the sky is blue")));
    }
}
