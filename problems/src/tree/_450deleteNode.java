package tree;

/**
 * @Description 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * @Author Zhang Qihang
 * @Date 2022/1/13 11:51
 */
public class _450deleteNode {
    // 通过删除操作返回新节点
    public TreeNode deleteNode(TreeNode root, int key) {
        // 确定终止条件，如果走到头了，说明没找到删除的节点，返回即可。
        if (root == null) {
            return root;
        }
        // 单层逻辑 找到了要删除的节点
        // 1. 左右节点均为空，直接删除
        // 2. 左空右不为空，右孩子补位为根节点
        // 3. 左不为空右空，左孩子补位为根节点
        // 4. 左右均不为空，左孩子补到有孩子的最左边节点的做孩子上
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = root.left;
                return root.right;
            }

        }
        // 这里的return root一般是递归回到开始节点返回的，只要不是根节点，一般不会用到这里的return，而是在判断的时候进行递归
        return root;
    }
}
