package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429levelOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        // 采用队列的方式，先入先出
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return res;
        Node curNode = new Node();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //首先计算当前队列中的大小，也就是当前层节点个数，注意的是，这里需要使用固定Size，因为queue.size是一直变的
            int layerSize = queue.size();
            // 依次对当前层节点执行队列弹出->进入temp数组->队列弹入children的操作
            for (int i = 0; i < layerSize; i++) {
                curNode = queue.poll();
                temp.add(curNode.val);
                for (int j = 0; j < curNode.children.size(); j++) {
                    queue.add(curNode.children.get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }
}
