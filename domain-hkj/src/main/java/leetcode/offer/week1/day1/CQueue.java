package leetcode.offer.week1.day1;

import java.util.Stack;

public class CQueue {

    private final Stack<Integer> stackTail;
    private final Stack<Integer> stackHead;

    public CQueue() {
        stackTail = new Stack<>();
        stackHead = new Stack<>();
    }

    public void appendTail(int value) {
        stackTail.push(value);
    }

    public int deleteHead() {

        if (!stackHead.isEmpty()) {
            return stackHead.pop();
        } else {
            while (!stackTail.isEmpty()) {
                stackHead.push(stackTail.pop());
            }
        }
        return stackHead.isEmpty() ? -1 : stackHead.pop();
    }

}

