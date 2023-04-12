package sword;

import java.util.Stack;

/**
 09. 用两个栈实现队列
 */
public class Coder23 {

    static class CQueue {

        public CQueue() {

        }

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void appendTail(int value) {
            stack1.push(value);

        }

        public int deleteHead() {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }


            if (!stack2.empty()) {
                int result = stack2.pop();
                stack1.clear();

                while (!stack2.empty()) {
                    stack1.push(stack2.pop());
                }

                stack2.clear();
                return result;
            } else {
                return -1;
            }
        }
    }
}
