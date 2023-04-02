package sword;

import entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Coder16 {
    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }

        Set<ListNode> nodeSet = new HashSet<>();

        ListNode next = head;
        ListNode result = null;
        while (null != next) {
            nodeSet.add(next);

            if (null != next.next && nodeSet.contains(next.next)) {
                result = next.next;
                break;
            }

            next = next.next;
        }

        return result;
    }
}
