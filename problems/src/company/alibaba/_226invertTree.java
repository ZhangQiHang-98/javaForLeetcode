package company.alibaba;

/**
 * @Description 反转二叉树
 * @Author Zhang Qihang
 * @Date 2022/2/4 20:09
 */
public class _226invertTree {
    // 先反转下面的，再反转上面的
    public TreeNode invertTree(TreeNode root) {
        //终止条件
        if (root == null) {
            return null;
        }
        // 后序遍历
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 在这里进行翻转
        root.left = right;
        root.right = left;
        return root;
    }
}
