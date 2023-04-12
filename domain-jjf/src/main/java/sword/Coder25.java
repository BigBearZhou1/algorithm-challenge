package sword;

import java.util.HashMap;

/**
 ["LRUCache","put","put","get","put","get","put","get","get","get"]
 [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
 ! ! 1 11,33 ! 1144 1 -1 4
 ["LRUCache","put","put","put","put","get","get"]
 [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

 [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
 */
public class Coder25 {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);

        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }



    static class LRUCache {
        private HashMap<Integer, Node> map = new HashMap<>();

        private int capacity;

        private int size = 0;

        private Node head;

        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = tail = null;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            Node prev = node.prev;
            Node next = node.next;

            if (null == next && null != prev) {
                prev.next = null;
                tail = prev;
                node.next = head;
                node.prev = null;
                head.prev = node;
                head = node;
            } else if (null != next && null != prev){
                prev.next = next;
                next.prev = prev;

                head.prev = node;
                node.next = head;
                head = node;
            }

            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node remove = map.remove(key);

                Node next = remove.next;
                Node prev = remove.prev;
                if (next == null && prev == null) {
                    head = tail = null;
                } else if (next == null && prev != null) {
                    prev.next = null;
                } else if (next != null && prev == null) {
                    next.prev = null;
                } else {
                    next.prev = prev;
                    prev.next = next;
                }
                size--;
                put(key, value);
            } else {
                Node node = new Node(key, value);
                if (size < capacity) {
                    if (size == 0) {
                        head = node;
                        tail = node;
                        map.put(key, node);
                    } else {
                        head.prev = node;
                        node.next = head;
                        head = node;
                    }
                    size ++;
                } else {
                    map.remove(tail.key);
                    if (size == 1) {
                        tail.key = key;
                        tail.value = value;
                        map.put(key, tail);
                        return;
                    }
                    tail = tail.prev;
                    tail.next = null;
                    head.prev = node;
                    node.next = head;
                    head = node;
                }
                map.put(key, node);
            }
        }
    }

    static class Node {
        private Node prev;

        private Node next;

        private int key;

        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
