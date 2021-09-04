package tree;/**
 * @Description
 * @Author by Zhang Qihang
 * @Date 2021/9/2 19:07
 */

/**
 * @Description 平衡二叉树
 * @Author Zhang Qihang
 * @Date 2021/9/2 19:07
 */
public class _100isBalanced {
    /*    // 返回当前节点的高度
        public int helper(TreeNode root) {
            // 1.终止条件
            if (root == null) {
                return 1;
            }
            // 判断逻辑，当前节点的高度为左右节点中最高的那个+1
            return Math.max(helper(root.left), helper(root.right)) + 1;
        }

        public boolean helper_(TreeNode root) {
            if(root == null){
                return true;
            }
            if(Math.abs(helper(root.left)-helper(root.right))>1){
                return false;
            }else{
                return helper_(root.left) && helper_(root.right);
            }

        }

        // 遍历所有节点，对每个节点都判断一下是否左右子树不平衡
        public boolean isBalanced(TreeNode root) {
            return helper_(root);
        }*/
    // 自己的递归方法只是去计算了高度，并没有保存是否平衡。
    // 因此后面还需要再去遍历一次，看对应的到底有没有平衡。
    // 改进算法是在计算高度的时候，如果不平衡就返回-1做个标记。

    // 1.参数：当前节点 返回类型：节点的高度
    public int getHeight(TreeNode root) {
        // 终止条件：root为null，走到最低，为0
        if (root == null) {
            return 0;
        }

        // 如果左右有一个不平衡，说明不平衡，直接返回-1。
        // 如果不返回-1，上一级节点会选择最大的高度值
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1) return -1;
        // 如果左右不平衡，则返回-1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
}
