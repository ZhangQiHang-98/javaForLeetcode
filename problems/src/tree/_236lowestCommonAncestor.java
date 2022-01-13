package tree;

import sun.reflect.generics.tree.Tree;

/**
 * @Description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @Author Zhang Qihang
 * @Date 2022/1/12 21:39
 */
public class _236lowestCommonAncestor {
    TreeNode res;
    // 二叉树的祖先，说明是从下往上的过程，因此考虑后序遍历
    // 如果找到一个节点，发现左子树出现结点p，右子树出现节点q，
    // 或者 左子树出现结点q，右子树出现节点p，那么该节点就是节点p和q的最近公共祖先

    // 定义fx表示x的子树中是否包含p或者q f_lson表示左子树是否包含
    // 如果节点x是最近公共祖先，那么他一定满足以下条件：
    // (f_lson && f_rson)|| ( (x=p）|| (x=q)) && (f_lson || f_rson))
    // 最近的特性是通过后序遍历，自底向上访问保证的，最近的一定是鲜卑访问都的

    // 递归函数表示root的子树是否包含p或者q（也就是上文中的f_son）
    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        // 递归中止条件
        if (root == null) {
            return false;
        }

        // 后序遍历
        boolean f_lson = helper(root.left, p, q);
        boolean f_rson = helper(root.right, p, q);

        // 当前层是否是最近公共节点的判断
        if ((f_lson && f_rson) || ((root.val == p.val || root.val == q.val) && (f_lson || f_rson))) {
            res = root;
        }

        // 当前层对于f_son的判断
        return f_lson || f_rson || root.val == q.val || root.val == p.val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        helper(root, p, q);
        return res;
    }
}
