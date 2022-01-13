package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * @Author Zhang Qihang
 * @Date 2022/1/11 19:58
 */
public class _530getMinimumDifference {
    List<Integer> res = new ArrayList<>();
    int resVal = Integer.MAX_VALUE;
    TreeNode pre;

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

    // 最小差值只能在所有的当前根与左右节点中找到，也不对，[236,104,701,null,227,null,911]这个例子就不是
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < res.size() - 1; i++) {
            int temp = Math.abs(res.get(i + 1) - res.get(i));
            minVal = Math.min(temp, minVal);
        }
        return minVal;
    }

    // 使用pre指针的方法
    public void _helper(TreeNode root) {
        // 创建指针，指向当前节点的前一个节点

        // 递归中止
        if (root == null) {
            return;
        }
        // 中序递归
        _helper(root.left);
        // 处理当前值
        if (pre != null) {
            resVal = Math.min(pre.val, root.val);
        }
        pre = root; // 将当前节点记为上一个节点
        _helper(root.right);
    }

    // 直接在中序遍历的过程中求解，不需要记录数组了。
    public int _getMinimumDifference(TreeNode root) {
        _helper(root);
        return resVal;
    }
}
