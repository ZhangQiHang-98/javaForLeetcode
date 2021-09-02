package tree;

import java.util.LinkedList;
import java.util.Queue;

public class _111minDepth {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = new TreeNode();
        queue.add(root);
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                temp = queue.poll();
                if (temp.left == null && temp.right == null) return res;
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            res += 1;
        }
        return res;
    }
}
