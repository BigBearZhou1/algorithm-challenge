package matrix;

public class MinPathSum64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int j = 0; j <= col; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        dp[1][1] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = {{1,2,3},{4,5,6}};
        MinPathSum64 solution = new MinPathSum64();
        int res = solution.minPathSum(grid);
        System.out.println(res);
    }
}
