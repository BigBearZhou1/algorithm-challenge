package leetcode.offer.week1.day5;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class RandomList {


    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.random = n1.next;
        n1.next.random = n1;
        new RandomList().copyRandomList(n1);
    }
}
