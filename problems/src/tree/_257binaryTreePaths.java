package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * @Author Zhang Qihang
 * @Date 2022/1/6 17:00
 */
public class _257binaryTreePaths {
    List<Integer> path = new ArrayList<>();
    List<String> res = new ArrayList<>();

    //先处理本身，然后处理左右节点，因此应该是先序遍历
    //1.参数为当前节点，返回值应该为到该节点所经的路径（用ArrayList表示）
    public void helper(TreeNode root, List<Integer> path, List<String> res) {
        // 存入当前值
        path.add(root.val);
        // 判断是否为叶子节点
        if (root.left == null && root.right == null) {
            // 将结果放入res中
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            return;
        }
        // 递归左右节点
        if (root.left != null) {
            helper(root.left, path, res);
            // 回溯
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            helper(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, path, res);
        return res;
    }
}
