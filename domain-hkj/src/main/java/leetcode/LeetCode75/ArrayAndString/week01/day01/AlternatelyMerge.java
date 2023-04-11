package leetcode.LeetCode75.ArrayAndString.week01.day01;

public class AlternatelyMerge {
    public String mergeAlternately(String word1, String word2) {
        if (null == word1) return word2;
        if (null == word2) return word1;
        StringBuilder sb = new StringBuilder();
        int j = 0;
        int i = 0;
        int w2Len = word2.length();
        int w1Len = word1.length();
        while (i<w1Len||j<w2Len){
            if(i < w1Len){
                sb.append(word1.charAt(j));
                i++;
            }
            if (j < w2Len) {
                sb.append(word2.charAt(j));
                j++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AlternatelyMerge().mergeAlternately("abc", "pqr"));
    }
}
