package tree;

/**
 * @Description 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。  你
 * 需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 * @Author Zhang Qihang
 * @Date 2022/1/10 22:02
 */
public class _617mergeTrees {
    // 构造树，上边用不到下面，所以先序遍历，先处理当前节点
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode node = new TreeNode();
        // 如果两个节点都走到了空节点，就返回
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null && root2 != null) {
            // 如果一个为空，一个不为空，填为有的那个值
            node.val = root2.val;
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
        } else if (root1 != null && root2 == null) {
            node.val = root1.val;
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
        } else {
            // 如果当前都不为空
            node.val = (root1.val + root2.val);
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        }
        return node;
    }
}
