package leetcode.offer.week05.Day01;

public class Stock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int in = 0;
        int maxP = 0;
        while (in < len - 1) {
            for (int out = in + 1; out < prices.length; out++) {
                int p = prices[out] - prices[in];
                if (p > maxP) {
                    maxP = p;
                }
            }
            in++;
        }
        return maxP;
    }

    public int maxProfitAdvance(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        System.out.println( new Stock().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
