package tree;

/**
 * @Description 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * @Author Zhang Qihang
 * @Date 2022/1/13 11:45
 */
public class _701insertIntoBST {
    // 通过递归函数的返回值完成父子节点的赋值是可以带来便利的
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 确定终止条件
        if (root == null) {
            // 如果根节点这里为空，说明找到了要防止的地方
            TreeNode node = new TreeNode(val);
            return node;
        }
        // 单层逻辑
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
