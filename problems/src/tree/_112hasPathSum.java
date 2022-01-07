package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * @Author Zhang Qihang
 * @Date 2022/1/7 12:00
 */
public class _112hasPathSum {
    // 先处理本身，然后处理左右节点，是先序遍历
    public void helper(TreeNode root, int path, List<Integer> paths) {
        if (root == null) {
            return;
        }
        // 单层递归逻辑
        path += root.val;
        // 已经走到了叶子节点
        if (root.left == null && root.right == null) {
            paths.add(path);
        } else {
            helper(root.left, path, paths);
            helper(root.right, path, paths);
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res.contains(targetSum) ? true : false;
    }
}
