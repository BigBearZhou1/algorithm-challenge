package sword;

import java.util.*;

/**
 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2][4,1,-1,2,-1,2,3]
 2
 XXXXXX
 */
public class Coder30 {
    public static void main(String[] args) {
        Coder30 coder30 = new Coder30();
        int[] ints = coder30.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
        Arrays.stream(ints).forEach(System.out::println);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Map<Integer, List<Integer>> mapK = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (mapK.containsKey(entry.getValue())) {
                mapK.get(entry.getValue()).add(entry.getKey());
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                mapK.put(entry.getValue(), list);
            }
        }

        Integer[] integers = mapK.keySet().toArray(new Integer[0]);
        Arrays.sort(integers);

        List<Integer> result = new ArrayList<>();
        for (int i = integers.length - 1; i >=0; i--) {
            result.addAll(mapK.get(integers[i]));
            if (result.size() >= k ) {
                break;
            }
        }


        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = result.get(i);
        }

        return res;

    }

}
