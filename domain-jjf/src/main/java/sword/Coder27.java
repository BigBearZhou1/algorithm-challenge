package sword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 */
public class Coder27 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");

        System.out.println(replaceWords(list, "the cattle was rattled by the battery"));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Set<String> dictSet = new HashSet<>(dictionary);
        StringBuilder sb = new StringBuilder();
        loop1: for (String word: words) {
            for (int i = 0; i < word.length(); i ++) {
                if (dictSet.contains(word.substring(0, i+1))) {
                    sb.append(word, 0, i+1).append(" ");
                    continue loop1;
                }

            }
            sb.append(word).append(" ");
        }

        return sb.toString().trim();
    }
}
