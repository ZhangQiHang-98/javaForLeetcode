package tree;

/**
 * @Description 计算给定二叉树的所有左叶子之和。
 * @Author Zhang Qihang
 * @Date 2022/1/6 19:36
 */
public class _404sumOfLeftLeaves {
    // 返回当前节点下的左叶子数值
    // 左叶子：左节点不为空，左节点没有左右孩子，那么这个左节点就是左叶子
    // 因此是后序遍历，通过返回值累加
    public int sumOfLeftLeaves(TreeNode root) {
        //2. 终止条件
        if (root == null) {
            return 0;
        }
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);
        int curValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            curValue = root.left.val;
        }
        return curValue + leftValue + rightValue;
        //
    }
}
