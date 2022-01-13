package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * @Author Zhang Qihang
 * @Date 2022/1/11 19:36
 */
public class _98isValidBST {
    // 第一遍思考错了，只考虑局部的左<中<右了，没有考虑整体的，感觉直接中序遍历，如果是BST，那么输出的数组递增
    List<Integer> res = new ArrayList<>();

    public void helper(TreeNode root) {
        // 终止条件
        if (root == null) {
            return;
        }

        // 单层逻辑
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        helper(root);
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
