package sword;

import entity.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Coder21 {
    public void reorderList(ListNode head) {
        if (null == head) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();

        ListNode tmpNode = head;
        while (null != tmpNode) {
            stack.push(tmpNode);
            queue.offer(tmpNode);
            tmpNode = tmpNode.next;
        }

        ListNode popStack = stack.pop();
        ListNode pollQueue = queue.poll();
        ListNode lastNode = null;

        while (popStack != pollQueue && lastNode != pollQueue  && null != popStack && null != pollQueue) {
            pollQueue.next = popStack;
            if (null != lastNode) {
                lastNode.next = pollQueue;
            }

            lastNode = popStack;
            popStack = stack.pop();
            pollQueue = queue.poll();
        }

        if (null != popStack && popStack == pollQueue && null != lastNode) {
            lastNode.next = pollQueue;
            pollQueue.next = null;
        } else if (null != lastNode) {
            lastNode.next = null;
        }
    }
}
