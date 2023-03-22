package leetcode.offer.week2.day3;

public class MissingNumber {
    public int missingNumber(int[] nums) {

        int n = nums.length + 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n - 1;
    }

}
