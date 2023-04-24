package sword;

/**
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 */
public class Coder32 {
    public static void main(String[] args) {
        System.out.println(new Coder32().isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }

        String s1 = s.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (isValid(s1.charAt(i))) {
                sb.append(s1.charAt(i));
            }
        }

        System.out.println(sb.toString());
        for (int i = 0; i < sb.length(); i ++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValid(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') ) {
            return true;
        }
        return false;
    }

}
