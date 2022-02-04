package tree;

/**
 * @Description 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * @Author Zhang Qihang
 * @Date 2022/2/2 22:00
 */
public class _235lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
