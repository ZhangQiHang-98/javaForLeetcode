package tree;

public class _222countNodes {

    //1.参数和返回值。
    // 参数为当前节点，返回值为含当前节点的总个数
    public int helper(TreeNode root) {
        //2.确定中止条件，当前节点为空，就返回
        if (root == null) return 0;
        return helper(root.left) + helper(root.right) + 1;
    }

    // 按照普通二叉树的做法来解
    public int countNodes(TreeNode root) {
        return helper(root);
    }

    // 如果考虑完全二叉树的特性
    // 计算深度（完全二叉树）
    public int countLevel(TreeNode node) {
        int level = 0;
        while (node != null) {
            node = node.left;
            level += 1;
        }
        return level;
    }

    //1.参数和返回值，参数是当前节点，返回值为含当前节点的总个数
    public int countNodes_(TreeNode root) {
        // 2.终止条件
        if (root == null) return 0;
        int left_level = countLevel(root.left);
        int right_level = countLevel(root.right);
        // 如果左子树和右子树高度相当，那左子树肯定是满二叉树，可以直接计算
        if (left_level == right_level) {
            return (1 << left_level) + countNodes_(root.right);
        } else {
            return (1 << right_level) + countNodes_(root.left);
        }
    }
}
