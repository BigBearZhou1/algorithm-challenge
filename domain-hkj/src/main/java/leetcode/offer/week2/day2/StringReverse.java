package leetcode.offer.week2.day2;

public class StringReverse {


    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n));
        sb.append(s, 0, n);
        return sb.toString();
    }


}
