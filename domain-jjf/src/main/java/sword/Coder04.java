package sword;

import java.util.HashSet;
import java.util.Set;

/**
 12. 矩阵中的路径
 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
 "ABCESEEEFS"
 */
public class Coder04 {
    public static void main(String[] args) {
        char[][] board = {{'a','b','c','e'},{'s','f','e','s'},{'a','d','e','e'}};
        Coder04 coder04 = new Coder04();
        boolean abcced = coder04.exist(board, "abceseeefs");
        System.out.println(abcced);
    }

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }

        int row = board.length;
        if (row == 0) {
            return false;
        }

        int column = board[0].length;
        char[] chars = word.toCharArray();

        for (int x = 0; x < row; x ++) {
            for (int y = 0; y < column; y ++) {
                boolean result = find(board, x, y, chars, 0, new HashSet<>());
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean find(char[][] board, int x, int y, char[] words, int pos, Set<String> runPath) {
        if (pos == words.length) {
            return true;
        }

        int row = board.length;
        int column = board[0].length;
        if (x >= row || y >= column || x < 0 || y < 0) {
            return false;
        }

        if (runPath.contains(x + "#" + y)) {
            return false;
        }

        if (board[x][y] == words[pos]) {
            runPath.add(x + "#" + y);
            boolean result = find(board, x + 1, y, words, pos + 1, runPath) || find(board, x - 1, y, words, pos + 1, runPath)
                    || find(board, x, y + 1, words, pos + 1, runPath) || find(board, x, y - 1, words, pos + 1, runPath);
            if (!result) {
                runPath.remove(x + "#" + y);
            }
            return result;
        } else {
            return false;
        }
    }

    public boolean exist2(char[][] board, String word) {
        if (null == board ) {
            return false;
        }

        if (null == word || word.length() == 0) {
            return true;
        }

        int length = board.length;
        int height = board[0].length;

        if (word.length() > length * height) {
            return false;
        }

        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < length; j ++) {

                if (match(board, j, i, word, 0, new HashSet<>())) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean match(char[][] board, int x, int y, String word, int pos, Set<String> paths) {


        if (board[x][y] != word.charAt(pos)) {
            return false;
        } else {
            paths.add(x + "*" + y);
            if (pos == word.length() - 1) {
                return true;
            }

            int length = board.length;
            int height = board[0].length;

            boolean canUp = (y-1) >= 0 && !paths.contains(x + "*" + (y-1));
            boolean canDown = (y+1) < height && !paths.contains(x + "*" + (y+1));
            boolean canLeft = (x-1) >= 0 && !paths.contains((x-1) + "*" + y);
            boolean canRight = (x+1) < length && !paths.contains((x+1) + "*" + y);

            if (canUp || canDown || canLeft || canRight) {
                boolean res = (canUp && match(board, x, y - 1, word, pos + 1, paths)) ||
                        (canDown && match(board, x, y + 1, word, pos + 1, paths)) ||
                        (canLeft && match(board, x-1, y, word, pos + 1, paths)) ||
                        (canRight && match(board, x+1, y, word, pos + 1, paths));
                if (!res) {
                    paths.remove(x + "*" + y);
                }
                return res;
            } else {
                paths.remove(x + "*" + y);
                return false;
            }
        }
    }
}
