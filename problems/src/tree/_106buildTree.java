package tree;

import java.util.HashMap;

/**
 * @className: _106buildTree
 * @Description: 根据一棵树的中序遍历与后序遍历构造二叉树。
 * @author: Zhang Qihang
 * @date: 2022/1/9 19:28
 */
// 改进方法：将中序列表存放在哈希表中，因为每次都是在中序列表中查找根的位置
public class _106buildTree {
    // 1.取后续数组的最后一个元素作为节点元素
    // 2.找到该元素在中序数组中的位置，作为切割点
    // 3.切割中序，切为中序左和中序右
    // 4.切割后序，切为后序左和后序右
    // 5.递归处理左区间和右区间
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] post;

    // is,ie为中序遍历的开始与结束位置，ps和pe为后序遍历的开始和结束位置
    public TreeNode helper(int is, int ie, int ps, int pe) {
        // 如果走到了空节点
        if (ie < is || pe < ps) {
            return null;
        }
        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = helper(is, ri - 1, ps, ps + ri - 1 - is);
        node.right = helper(ri + 1, ie, ps + ri - is, pe);
        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = helper(0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }
}
