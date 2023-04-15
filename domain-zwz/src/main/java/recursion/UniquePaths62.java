package recursion;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths1(int m, int n) {
        return process(0, 0, m, n);
    }

    private int process(int row, int col, int m, int n) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (row == m || col == n) {
            return 0;
        }
        int res = 0;
        res += process(row + 1, col, m, n);
        res += process(row, col + 1, m, n);
        return res;
    }

    public static void main(String[] args) {
        UniquePaths62 solution = new UniquePaths62();
        int res = solution.uniquePaths(3, 3);
        System.out.println(res);
    }

}
