package leetcode.LeetCode75.ArrayAndString.week03;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class StringCompres {

    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                int len = read - left + 1;
                chars[write++] = chars[read];
                if (len > 1) {
                    // 长度 >1 写入字符串中
                    int anchor = write;
                    while (len > 0) {
                        chars[write++] = (char) (len % 10 + '0');
                        len = len / 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
