package tree;

/**
 * @Description 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * @Author Zhang Qihang
 * @Date 2022/1/14 21:19
 */
public class _538convertBST {
    // 先记录总和
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 不像一般的中序遍历，应该是右、左、中的遍历顺序，相当于递增序列从后往前遍历
        root.right = convertBST(root.right);
        // 当前层处理
        sum += root.val;
        root.val = sum;
        root.left = convertBST(root.left);
        // 返回结果
        return root;
    }
}
