package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * @Author Zhang Qihang
 * @Date 2022/1/7 22:08
 */
public class _113pathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return res;
        }
        dfs(root, targetSum, path, res);
        return res;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        path.add(root.val);
        // 如果遇到了叶子节点
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null) {
            dfs(root.left, targetSum - root.val, path, res);
            path.remove(path.size() - 1); // 回溯
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val, path, res);
            path.remove(path.size() - 1); // 回溯
        }
    }
}
