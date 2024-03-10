package tree;

import java.util.ArrayList;
import java.util.List;

public class LowestAncestorPro {

    static class Info {
        public MultiNode ans;
        public boolean findO1;
        public boolean findO2;

        public Info(MultiNode a, boolean f1, boolean f2) {
            ans = a;
            findO1 = f1;
            findO2 = f2;
        }
    }

    public MultiNode lowestAncestorPro(MultiNode head, MultiNode o1, MultiNode o2) {
        return process(head, o1, o2).ans;
    }

    private Info process(MultiNode cur, MultiNode o1, MultiNode o2) {
        if (cur == null) {
            return new Info(null, false, false);
        }

        List<MultiNode> subNodes = cur.subNodes;
        List<Info> infos = new ArrayList<>();
        for (MultiNode subNode : subNodes) {
            infos.add(process(subNode, o1, o2));
        }

        boolean findO1 = cur == o1 || infos.stream().anyMatch(e -> e.findO1);
        boolean findO2 = cur == o2 || infos.stream().anyMatch(e -> e.findO2);

        MultiNode ans = infos.stream()
                .filter(e -> e.ans != null)
                .findAny()
                .orElseGet(() -> new Info(null, false, false))
                .ans;

        if (ans == null) {
            if (findO1 && findO2) {
                ans = cur;
            }
        }
        return new Info(ans, findO1, findO2);
    }
}
