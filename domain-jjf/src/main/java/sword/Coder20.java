package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * Offer II 011. 0 和 1 个数相同的子数组
 *
 输入: nums = [0,1,0]
 输出: 2
 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 */
public class Coder20 {
    public int findMaxLength(int[] nums) {
        if (null == nums) {
            return 0;
        }

        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            sum += (nums[i] == 0 ? -1 : nums[i]);

            if (sum == 0) {
                max = Math.max(max, i + 1);
            } else if (map.containsKey(sum)){
                max = Math.max(max, i - map.get(sum) );
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return max;

    }
}
