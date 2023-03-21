package leetcode.offer.week2.day2;

import java.util.Arrays;

public class Searcher {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ret = 0;
        int i = Arrays.binarySearch(nums, target);
        if (i < 0) {
            return 0;
        }
        System.out.println("num = " + nums[i]);
        System.out.println("index = " + i);
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] == target) {
                ret = ret + 1;
            } else {
                break;
            }
        }
        for (int j = i; j < n; j++) {
            if (nums[j] == target) {
                ret = ret + 1;
            } else {
                break;
            }
        }
        return ret;
    }
}
