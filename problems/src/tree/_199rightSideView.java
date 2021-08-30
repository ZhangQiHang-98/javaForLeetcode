package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199rightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        // 采用队列的方式，先入先出
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        TreeNode curNode = new TreeNode();
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // 如何衡量每一层的尺寸大小，是一个问题。
            // 在这里，我们先计算queue的大小，再将其全部清除，将其子节点全部加入，这样每次都是每层的大小了
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                curNode = queue.poll();
                temp.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(temp.get(layerSize - 1));
        }
        return res;
    }
}
