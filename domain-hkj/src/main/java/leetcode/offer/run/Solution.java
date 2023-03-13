package leetcode.offer.run;

import leetcode.offer.day1.CQueue;
import leetcode.offer.day2.MinStack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.runDay01();
        solution.runDay02();
    }

    private void runDay01(){
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
    }

    private void runDay02(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.min();
        System.out.println(minStack.min());

    }

}
