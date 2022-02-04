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

    // 定义fx表示x的子树中是否包含p或者q
    // 如果节点x是最近公共祖先，那么他一定满足以下条件：
    // 第一项是左有一个，右有一个  第二项是左右有一个 本身是一个
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

        // 当前层对于f_son的判断（单层逻辑）
        return f_lson || f_rson || root.val == q.val || root.val == p.val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        helper(root, p, q);
        return res;
    }

    public TreeNode _lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件
        // 比如在某一棵子树上先找到了p，则无需继续遍历这棵子树，因为即使这棵子树有q，p也一定是q的祖先，也就是它们两个的最近公共祖先。
        // 这里先找到谁，说明谁在上边
        if (root == null || root == q || root == p) {
            return root;
        }
        // 后序遍历
        TreeNode left = _lowestCommonAncestor(root.left, p, q);
        TreeNode right = _lowestCommonAncestor(root.right, p, q);
        // 如果左右子树都找到了（一个在左一个在右）
        if (left != null && right != null) {
            return root;
        }
        //一边找到了，一边没找到，根据上述规则，找到的就是最近公共祖先。
        return left == null ? right : left;
    }
}