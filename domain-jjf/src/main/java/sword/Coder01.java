package sword;

/**
 * 剑指 Offer 04. 二维数组中的查找
 [[1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]]

 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 给定 target = 5，返回 true。
 给定 target = 20，返回 false。
 0 <= n <= 1000
 0 <= m <= 1000
 */
public class Coder01 {
    public static void main(String[] args) {
        int[][] matrix = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        System.out.println(matrix.length);
                System.out.println(findNumberIn2DArray(matrix, 19));
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (null == matrix) {
            return false;
        }

        int row = matrix.length;
        if (row == 0) {
            return false;
        }

        int x = 0;
        int y = matrix[0].length - 1;

        while (x < matrix.length && y >= 0) {
            int val = matrix[x][y];
            if (target == val) {
                return true;
            } else if (target > val) {
                x++;
            } else {
                y--;
            }
        }

        return false;
    }

}
