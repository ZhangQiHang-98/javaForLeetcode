package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * @Author Zhang Qihang
 * @Date 2022/1/6 17:00
 */
public class _257binaryTreePaths {
    //先处理本身，然后处理左右节点，因此应该是先序遍历
    //1.参数为当前节点，返回值应该为到该节点所经的路径（用ArrayList表示）

    public void helper(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            // 如果是叶子节点
            if (root.left == null && root.right == null) {
                paths.add(pathSB.toString());
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                helper(root.left, pathSB.toString(), paths);
                helper(root.right, pathSB.toString(), paths);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        helper(root, "", paths);
        return paths;
    }
}
