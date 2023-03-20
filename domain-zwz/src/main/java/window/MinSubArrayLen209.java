package window;

public class MinSubArrayLen209 {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0, len = nums.length;
        int cur = 0;
        while (end < len) {
            cur += nums[end];
            while (cur >= target && start <= end) {
                min = Math.min(end - start + 1, min);
                cur -= nums[start];
                start++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinSubArrayLen209 solution = new MinSubArrayLen209();
        int res = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(res);
        int res1 = solution.minSubArrayLen(4, new int[]{1, 4, 4});
        System.out.println(res1);
        int res2 = solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println(res2);
    }
}
