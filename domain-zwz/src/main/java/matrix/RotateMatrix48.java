package matrix;

public class RotateMatrix48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[] lTop = new int[]{0, 0};
        int[] rTop = new int[]{0, n - 1};
        int[] lButton = new int[]{n - 1, 0};
        int[] rButton = new int[]{n - 1, n - 1};

        if (n == 2) {
            swapMatrix(matrix, lTop, rTop, lButton, rButton);
            return;
        }
        int i = 0;
        while (i < n - 2) {
            int j = 0;
            int len = rTop[1] - lTop[1];
            while (j < len) {
                swapMatrix(matrix, lTop, rTop, lButton, rButton);
                lTop[1] = lTop[1] + 1;
                rTop[0] = rTop[0] + 1;
                lButton[0] = lButton[0] - 1;
                rButton[1] = rButton[1] - 1;
                j++;
            }
            i++;
            lTop = new int[]{i, i};
            rTop = new int[]{i, n - i - 1};
            lButton = new int[]{n - i - 1, i};
            rButton = new int[]{n - i - 1, n - i - 1};
        }
    }

    private void swapMatrix(int[][] matrix, int[] lTop, int[] rTop, int[] lButton, int[] rButton) {
        int tmp = matrix[rTop[0]][rTop[1]];
        matrix[rTop[0]][rTop[1]] = matrix[lTop[0]][lTop[1]];
        matrix[lTop[0]][lTop[1]] = matrix[lButton[0]][lButton[1]];
        matrix[lButton[0]][lButton[1]] = matrix[rButton[0]][rButton[1]];
        matrix[rButton[0]][rButton[1]] = tmp;
    }

    public static void main(String[] args) {
        RotateMatrix48 solution = new RotateMatrix48();
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] matrix = {{1, 2}, {3, 4}};
        solution.rotate(matrix);
        System.out.println(matrix);
    }
}
