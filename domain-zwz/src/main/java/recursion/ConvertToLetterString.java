package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 一串数字”1101“转换成字符串
 * 1101可能是AJA，也可能是AA0A（这种情况不算转换成功）
 * 求这种字符串可以有多少种转换可能
 */
public class ConvertToLetterString {

    public int convertToLetterString(String str) {
        return process(str.toCharArray(), 0);
    }

    private int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1);
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }

        if (str[i] == '2') {
            int res = process(str, i + 1);
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process(str, i + 2);
            }
        }
        return process(str, i + 1);
    }

    public static void main(String[] args) {
//        ConvertToLetterString solution = new ConvertToLetterString();
//        int res = solution.convertToLetterString("1129");
//        System.out.println(res);
//        String s = "a" + (char) (Integer.parseInt('1' + "") + 'a' - 1);
//        System.out.println(s);

        ConvertToLetterString solution = new ConvertToLetterString();
        List<String> strings = solution.convertToLetterString2("111");
        System.out.println(strings);

    }

    public List<String> convertToLetterString2(String str) {
        List<String> res = new ArrayList<>();
        process(str.toCharArray(), 0, "", res);
        return res;
    }

    private void process(char[] chars, int i, String cur, List<String> res) {
        if (i == chars.length) {
            res.add(cur);
            return;
        }
        if (chars[i] == '0') {
            return;
        }

        if (chars[i] == '1') {
            process(chars, i + 1, cur + (char) (Integer.parseInt((chars[i]+"")) + 'a' - 1), res);
            if(i+1<chars.length){
                process(chars,i+2,cur+(char)(Integer.parseInt(chars[i]+"")+Integer.parseInt(chars[i+1]+"")+'a'-1),res);
            }
        }
        if(chars[i] == '2'){
            process(chars, i + 1, cur + (char) (Integer.parseInt((chars[i]+"")) + 'a' - 1), res);
            if(i+1<chars.length&&chars[i+1]<='6'){
                process(chars,i+2,cur+(char)(Integer.parseInt(chars[i]+"")+Integer.parseInt(chars[i+1]+"")+'a'-1),res);
            }
        }
        process(chars, i + 1, cur + (char) (Integer.parseInt((chars[i]+"")) + 'a' - 1), res);
    }
}
