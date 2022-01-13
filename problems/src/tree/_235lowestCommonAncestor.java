package tree;

/**
 * @Description 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * @Author Zhang Qihang
 * @Date 2022/1/12 22:42
 */

// 两次遍历，记录到p，到q的路径，找到第一个分歧点之前的那个点。
// 一次遍历，如果当前节点在[p,q]中间，就说明为最近公共祖先，迭代此值即可
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
