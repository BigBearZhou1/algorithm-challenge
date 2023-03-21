package leetcode.offer.run;

import leetcode.offer.week1.day1.CQueue;
import leetcode.offer.week1.day2.MinStack;
import leetcode.offer.week1.day3.ReversePrintListNode;
import leetcode.offer.week1.day4.ListReverse;
import leetcode.offer.week2.day1.StringWithoutSpace;
import leetcode.offer.week2.day2.RepeatNumberSearcher;
import leetcode.offer.week2.day2.StringReverse;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.runDay01();
//        solution.runDay02();
//        solution.runDay03();
//        solution.runDay04();
//        solution.runDay06();
        solution.runDay07();
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

    private void runDay06(){
        String s = new StringWithoutSpace().replaceSpace("We are happy.");
        System.out.println(s);
    }
    private void runDay07(){
        String s = new StringReverse().reverseLeftWords("abcdefg", 2);
        String s2 = new StringReverse().reverseLeftWords("lrloseumgh", 6);
        System.out.println(s);
        System.out.println(s2);
        int number = new RepeatNumberSearcher().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        int number1 = new RepeatNumberSearcher().findRepeatNumberInhanced(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(number);
        System.out.println(number1);
    }
}
