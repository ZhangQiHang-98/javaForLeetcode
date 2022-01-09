package tree;

import java.util.HashMap;

/**
 * @className: _105buildTree
 * @Description: 给定一棵树的前序遍历preorder与中序遍历inorder。请构造二叉树并返回其根节点
 * @author: Zhang Qihang
 * @date: 2022/1/9 20:53
 */
public class _105buildTree {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] pre;

    // 分别为中序遍历的开始结束点，后序遍历的开始结束点
    public TreeNode helper(int is, int ie, int ps, int pe) {
        // 当前节点是叶子结点的孩子
        if (ie < is || pe < ps) {
            return null;
        }
        // 当前的根节点
        int root = pre[ps];
        int ri = memo.get(root);
        TreeNode node = new TreeNode(root);
        node.left = helper(is, ri - 1, ps + 1, ps + ri - is);
        node.right = helper(ri + 1, ie, ps + ri - is + 1, pe - 1);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        pre = preorder;
        TreeNode root = helper(0, inorder.length - 1, 0, preorder.length - 1);
        return root;
    }
}
