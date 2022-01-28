package tree;


/**
 * @Description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * @Author Zhang Qihang
 * @Date 2022/1/11 19:36
 */
public class _98isValidBST {
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        // 单层逻辑
        if (pre != null) {
            if (pre.val > root.val) {
                return false;
            }
        }
        pre = root;
        return isValidBST(root.right);
    }
}
