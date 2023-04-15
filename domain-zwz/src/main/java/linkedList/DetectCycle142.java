package linkedList;

/**
 * 环形链表2
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * a是循环入口距离head的长度, b是循环部分长度, k是慢指针每次走到循环入口的步数
 * f = 2s, f = s + nb => 每次相遇时 s = nb
 * k = a + nb , 相遇后s只需要再走a步就可以到达入口
 */
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
