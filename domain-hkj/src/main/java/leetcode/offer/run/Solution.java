package leetcode.offer.run;

import leetcode.offer.day1.CQueue;

public class Solution {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
    }
}
