package leetcode.offer.week04.day04;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    int mod = 1000000007;


    public int fib(int n) {

//        int[] res = new int[n + 1];
//        res[0] = 0;
//        res[1] = 1;
        int fn1 = 0, fn2 = 0;
        int res = 1;
        if (n < 2) return n;
        for (int i = 2; i < n + 1; i++) {
            fn1 = fn2;
            fn2 = res;
            res = (fn1 + fn2) % mod;
//            res[i] = res[i - 1] + res[i - 2];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fib(48));
    }
}
