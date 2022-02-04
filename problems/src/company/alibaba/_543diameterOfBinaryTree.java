package company.alibaba;

/**
 * @Description 给定一棵二叉树，你需要计算它的直径长度。
 * @Author Zhang Qihang
 * @Date 2022/2/3 17:01
 */
public class _543diameterOfBinaryTree {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        helper(root);
        // 长度是节点数-1
        return ans - 1;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 求左右节点的最长路径，由于是高度，所以是后序
        int left = helper(root.left);
        int right = helper(root.right);

        ans = Math.max(left + right + 1, ans);
        // 这里的+1是指当前节点
        return Math.max(left, right) + 1;
    }
}
