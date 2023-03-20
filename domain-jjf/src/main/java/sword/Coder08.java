package sword;

/**
 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。

 输入: nums = [10,5,2,6], k = 100
 输出: 8
 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 */
public class Coder08 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(null == nums || nums.length == 0) {
            return 0;
        }
        int start_index = 0;
        int end_index = 0;
        int sum = 1;
        int count = 0;

        while (end_index < nums.length && start_index <= end_index) {
            sum *= nums[end_index];
            while (sum >= k && start_index <= end_index) {
                sum = sum /nums[start_index++];
            }

            end_index++;
            count = count + end_index - start_index;
        }

        return count;
    }

}
