package tree;

import lombok.AllArgsConstructor;

public class MaxSubBSTHead {

    @AllArgsConstructor
    static
    class Info {
        public Node maxSubBSTHead;
        public int maxSubBSTSize;
        public int min;
        public int max;

    }


    public Node maxSubBSTHead(Node head) {
        if (head == null) {
            return null;
        }
        Info info = process(head);
        return info.maxSubBSTHead;
    }

    public static Info process(Node X) {
        if (X == null) {
            return null;
        }
        Info leftInfo = process(X.getLeft());
        Info rightInfo = process(X.getRight());
        int min = X.getValue();
        int max = X.getValue();
        Node maxSubBSTHead = null;
        int maxSubBSTSize = 0;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            maxSubBSTHead = leftInfo.maxSubBSTHead;
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            if (rightInfo.maxSubBSTSize > maxSubBSTSize) {
                maxSubBSTHead = rightInfo.maxSubBSTHead;
                maxSubBSTSize = rightInfo.maxSubBSTSize;
            }
        }
        if ((leftInfo == null || (leftInfo.maxSubBSTHead == X.getLeft() && leftInfo.max < X.getValue()))
                && (rightInfo == null || (rightInfo.maxSubBSTHead == X.getRight() && rightInfo.min > X.getValue()))) {
            maxSubBSTHead = X;
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                    + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
        }
        return new Info(maxSubBSTHead, maxSubBSTSize, min, max);
    }
}
