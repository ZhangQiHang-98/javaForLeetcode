package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 给定一个二叉树，在树的最后一行找到最左边的值
 * @Author Zhang Qihang
 * @Date 2022/1/7 11:46
 */
public class _513findBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        TreeNode curNode = new TreeNode();
        queue.add(root);
        while (!queue.isEmpty()) {

            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                curNode = queue.poll();
                if (i == 0) {
                    res = curNode.val;
                }
                // 推入新孩子
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
        return res;
    }
}
