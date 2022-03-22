package tree;

/**
 * @Description 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * @Author Zhang Qihang
 * @Date 2022/3/9 10:50
 */
public class _124maxPathSum {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    // 返回的是以当前节点为路径为结尾（起点）的最大路径
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //计算左子树的最大值，必须要比0大
        int leftMax = Math.max(helper(root.left), 0);
        int rightMax = Math.max(helper(root.right), 0);
        // 记录最大res
        res = Math.max(res, root.val + leftMax + rightMax);

        return Math.max(leftMax, rightMax) + root.val;
    }
}
