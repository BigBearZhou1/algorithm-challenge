package window;

import java.util.LinkedList;

public class MaxSlidingWindow239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <=i-k) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
