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
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        //都不为空的情况
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(node.left,node.right);
        node.right = mergeTrees(node.right, node.right);

        return node;
    }
}
