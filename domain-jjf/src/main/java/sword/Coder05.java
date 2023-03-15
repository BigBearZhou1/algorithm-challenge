package sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class Coder05 {
    public int singleNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }

        Set<Integer> dup = new HashSet<>();
        for (int val : nums) {
            if (!dup.add(val)) {
                numSet.remove(val);
            }
        }
        return numSet.iterator().next();
    }

    //位运算
    public int singleNumber2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 32; i ++) {
            int count = 0;
            for (int num: nums) {
                count += num >> i & 1;
            }

            sum += count % 3 << i;
        }

        return sum;
    }


}
