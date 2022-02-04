package company.alibaba;

import java.util.*;

/**
 * @Description 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @Author Zhang Qihang
 * @Date 2022/2/2 21:36
 */
public class _103zigzagLevelOrder {

    // 使用双端队列
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            //双端队列只在存储这里使用，正常遍历还是用queue就行
            Deque<Integer> levelList = new LinkedList<>();
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode curNode = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            res.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }
}
