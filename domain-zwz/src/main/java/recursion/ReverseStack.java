package recursion;

import java.util.Stack;

/**
 * 将一个栈中的数字，不借助新的数据结构，逆序化
 */
public class ReverseStack {
    public void reserve(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = findLast(stack);
        reserve(stack);
        stack.push(last);
    }

    private int findLast(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = findLast(stack);
            stack.push(result);
            return last;
        }

    }
}
