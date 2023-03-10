package linkedList;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode cur = null;
        int carry = 0;/*进位*/

        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;/*null代换0值*/
            int v2 = l2 != null ? l2.val : 0;
            int curVal = v1 + v2 + carry;

            //区分初始化和一般流程
            if (res == null) {
                res = new ListNode(curVal % 10);
                cur = res;
            } else {
                cur.next = new ListNode(curVal % 10);
                cur = cur.next;
            }
            carry = curVal / 10;

            //巧妙移动链表指针
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        //最后检查还要不要进位
        if (carry != 0) {
            cur.next = new ListNode(1);
        }
        return res;
    }
}
