package sword;

import java.util.HashMap;
import java.util.Map;

/**
 输入:nums = [1,2,3], k = 3
 输出: 2
 */
public class Coder18 {
    public int subarraySum(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count +=map.get(sum - k);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }
}
