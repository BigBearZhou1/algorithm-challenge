package leetcode.offer.run;

import leetcode.offer.day1.CQueue;
import leetcode.offer.day2.MinStack;
import leetcode.offer.day3.ReversePrintListNode;
import leetcode.offer.day4.ListReverse;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.runDay01();
//        solution.runDay02();
//        solution.runDay03();
        solution.runDay04();
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

    private void runDay03(){
        ReversePrintListNode printListNode = new ReversePrintListNode();
        printListNode.run();
    }

    private void runDay04(){
        ListReverse reverse = new ListReverse();
        reverse.run();
    }
}
