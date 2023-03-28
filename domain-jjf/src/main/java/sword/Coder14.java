package sword;

/**
 * 2. 两数相加
 */
public class Coder14 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }

        if (null == l1 || null == l2) {
            return null == l1 ? l2 : l1;
        }

        ListNode res;
        int tmp12 = l1.val + l2.val;
        int nextAdd = 0;
        if (tmp12 < 10) {
            res = new ListNode(tmp12);
        } else {
            nextAdd = tmp12 / 10;
            res = new ListNode(tmp12 - nextAdd * 10);
        }

        ListNode result = res;

        l1 = l1.next;
        l2 = l2.next;
        while (null != l1 || null != l2) {
            int l1Val = 0;
            if (null != l1) {
                l1Val = l1.val;
                l1 = l1.next;
            }

            int l2Val = 0;
            if (null != l2) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            int tmpRes = l1Val + l2Val + nextAdd;
            if (tmpRes < 10) {
                nextAdd = 0;
                res.next = new ListNode(tmpRes);
            } else {
                nextAdd = tmpRes / 10;
                res.next = new ListNode(tmpRes - nextAdd * 10);
            }
            res = res.next;
        }


        if (nextAdd > 0) {
            res.next = new ListNode(nextAdd);
        }
        return result;
    }

     class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
