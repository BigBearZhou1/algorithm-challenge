package linkedList;

import java.nio.file.attribute.UserPrincipalNotFoundException;

/**
 * 删除链表的倒数第N个节点
 * 快慢指针
 * 在头节点前放至的虚假节点dummy
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;/*[1] 1 的情况下自己删除自己*/
    }
}
