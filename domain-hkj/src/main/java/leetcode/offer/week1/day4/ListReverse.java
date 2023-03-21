package leetcode.offer.week1.day4;

import java.util.Arrays;

public class ListReverse {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


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

    public ListNode reverseListNice(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }



    public ListNode reverseList(ListNode head) {
        int[] ints = reversePrint(head);
        if (ints.length == 0) {
            return null;
        }
        ListNode node = new ListNode(ints[0]);
        ListNode reversedNode = node;
        for (int i = 1; i < ints.length; i++) {
            node.next = new ListNode(ints[i]);
            node = node.next;
        }
        return reversedNode;
    }

    public void run() {
        ListNode node = reverseListNice(prepairData());
        StringBuilder sb = new StringBuilder();
        while (node!=null){
            sb.append(node.val);
            sb.append(",");
            node=node.next;
        }
        sb.delete(sb.lastIndexOf(","), sb.length()-1);
        System.out.println(sb);
    }
}
