package sword;

/**
 给定一个含有N个正整数的数组和一个正整数 target 。

 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 输入：target = 7, nums = [2,3,1,2,4,3]
 输出：2
 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class Coder07 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }


    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (left <= right && right < nums.length) {
            if (left == right) {
                sum = nums[left];
            }

            if (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left ++;
            } else {
                right ++;
                if (right < nums.length) {
                    sum += nums[right];
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
