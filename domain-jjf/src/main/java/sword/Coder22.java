package sword;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 [[1,4],[0,0]]
1，4 0，5
 */
public class Coder22 {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = {{1,4},{0,0}};
        Coder22 coder22 = new Coder22();
        int[][] merge = coder22.merge(intervals);
        for (int i = 0; i < merge.length; i ++) {
            System.out.println(merge[i][0] + " " + merge[i][1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        Node head = new Node(-1, -1);
        Node last = head;
        for (int i = 0; i < length; i++) {
            last = mergeNode(last, new Node(intervals[i][0], intervals[i][1]));
        }

        int count = 0;
        last = head;
        last = last.next;
        while (null != last) {
            count++;
            last = last.next;
        }

        int[][] result = new int[count][2];
        head = head.next;
        for (int i = 0; i < count; i ++) {
            result[i][0] = head.begin;
            result[i][1] = head.end;
            head = head.next;
        }

        return result;
    }

    public Node mergeNode(Node last, Node add) {
        if (add.begin > last.end) {
            last.next = add;
            add.prev = last;
            return add;
        } else if (add.begin >= last.begin) {
            last.end = Math.max(last.end, add.end);
            return last;
        } else if (add.end < last.begin) {
            Node prev = last.prev;
            if (null == prev) {
                add.next = last;
                last.prev = add;
            } else {
                prev.next = null;
                Node mergeNode = mergeNode(prev, add);
                mergeNode.next = last;
                last.prev = mergeNode;
            }
            return last;
        } else {
            last.begin = add.begin;
            last.end = Math.max(last.end, add.end);
            Node prev = last.prev;
            if (null != prev) {
                prev.next = null;
                return mergeNode(prev, last);
            }
            return last;
        }

    }

    static class Node {
        int begin;
        int end;
        Node next;
        Node prev;
        public Node(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}
