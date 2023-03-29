package sword;

import entity.ListNode;

/**
 * 021. 删除链表的倒数第 n 个结点
 */
public class Coder15 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next = head;
        int len = 0;
        while (next != null) {
            len ++;
            next = next.next;
        }

        if (n == len) {
            return head.next;
        }

        int find = len - n ;

        next = head;
        int i = 0;
        while (next != null) {
            i++;
            if (i == find) {
                ListNode nextNextLast = next.next.next;
                if (nextNextLast == null) {
                    next.next = null;
                } else {
                    next.next = nextNextLast;
                }
                break;
            }
            next = next.next;
        }

        return head;

    }
}
