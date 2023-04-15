package dp;

public class CanJump55 {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] >= i ? Math.max(nums[i] + i, dp[i - 1]) : 0;
            if (dp[i] >= nums.length - 1) {
                return true;
            }
        }
        return dp[nums.length - 1] > 0;
    }

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        CanJump55 solution = new CanJump55();
        boolean result = solution.canJump(nums);
        System.out.println(result);
    }
}
