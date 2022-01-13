package tree;

/**
 * @Description 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * @Author Zhang Qihang
 * @Date 2022/1/10 22:22
 */
public class _700searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        } else if (root.val < val) {
            root = searchBST(root.right, val);
        } else if (root.val > val) {
            root = searchBST(root.left, val);
        }
        return root;
    }

    // 迭代方法
    public TreeNode _searchBST(TreeNode root, int val) {
        while (root != null)
            if (val < root.val) root = root.left;
            else if (val > root.val) root = root.right;
            else return root;
        return root;
    }
}
