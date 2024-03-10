package tree;

public class LowestAncestor {

    static class Info {
        public Node ans;
        public boolean findO1;
        public boolean findO2;

        public Info(Node a, boolean f1, boolean f2) {
            ans = a;
            findO1 = f1;
            findO2 = f2;
        }
    }

    public Node lowestAncestor(Node head, Node o1, Node o2) {
        return process(head, o1, o2).ans;
    }

    private Info process(Node head, Node o1, Node o2) {
        if (head == null) {
            return new Info(null, false, false);
        }
        Info leftInfo = process(head.getLeft(), o1, o2);
        Info rightInfo = process(head.getRight(), o1, o2);

        boolean findO1 = leftInfo.findO1 || rightInfo.findO1 || head == o1;
        boolean find02 = leftInfo.findO2 || rightInfo.findO2 || head == o2;

        Node ans = null;

        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        }

        if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        }
        if (ans == null) {
            if (findO1 && find02) {
                ans = head;
            }
        }
        return new Info(ans, findO1, find02);
    }
}
