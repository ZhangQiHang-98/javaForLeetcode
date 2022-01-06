package tree;

/**
 * @Description 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * @Author Zhang Qihang
 * @Date 2022/1/6 16:46
 */
public class _110isBalanced {
    // 遍历左右子树的高度，如果差1，说明不是高度平衡的子树
    // 因为求深度可以从上到下去查 所以需要前序遍历（中左右），而高度只能从下到上去查，所以只能后序遍历（左右中）
    //1. 参数为当前传入的根节点，返回值是其为根节点的树的高度，如果不是二叉平衡树，标记为-1
    public int getHeight(TreeNode root) {
        //2. 终止条件，当前节点为空，说明高度为0
        if (root == null) {
            return 0;
        }
        //3. 单层逻辑：求左和右的，如果差值小于1，就返回当前的高度，否则返回-1即可
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1 ? false : true;
    }
}
