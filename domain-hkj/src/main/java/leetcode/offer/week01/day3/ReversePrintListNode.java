package leetcode.offer.week01.day3;


import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ReversePrintListNode {

    int[] results;

    public void printNext(ListNode head, int count) {
        if (head == null) {
            results = new int[count];
            return;
        }
        count++;
        printNext(head.next, count);
        results[results.length - count] = head.val;
    }

    public int[] reversePrint(ListNode head) {
        printNext(head, 0);
        return results;
    }

    public ListNode prepairData() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        return listNode;
    }


    public void run() {
        System.out.println(Arrays.toString(reversePrint(prepairData())));
    }
}
