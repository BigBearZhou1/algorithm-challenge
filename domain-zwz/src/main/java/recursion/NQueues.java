package recursion;

/**
 * N皇后
 * 在N*N的棋盘上要摆N个皇后
 * 要求任何两个皇后之间不能同行、不同列，也不能在同一个斜线上
 * 给定一个整数N，返回n皇后的摆法有多少种
 * n=1，返回1
 * n=2or3,无解，返回0
 * n=8，返回92
 */
public class NQueues {
    public int nQueues(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    private int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if(isVaild(record,i,j)){
                record[i] = j;
                res += process1(i+1,record,n);
            }
        }
        return res;
    }

    private boolean isVaild(int[] record, int i, int j) {
        for(int k = 0;k<i;k++){
            if(j==record[k]||Math.abs(record[k]-j)==Math.abs(i-k)){
                return false;
            }
        }
        return true;
    }
}
