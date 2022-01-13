package tree;

import java.util.ArrayList;

/**
 * @Description 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * @Author Zhang Qihang
 * @Date 2022/1/11 20:35
 */
public class _501findMode {
    int maxCount = 0;
    int curCount = 0;
    TreeNode pre;
    ArrayList<Integer> res = new ArrayList<>();

    // 注意考虑pre==null的情况
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        // 处理当前节点
        // 如果Pre为1，说明当前这个数为出现的第一个该数
        if (pre == null || pre.val != root.val) {
            curCount = 1;
        } else {
            // 与上一个数相等
            curCount++;
        }

        // 判断curCount和maxCount的关系，如果大于就清空
        // 这里注意是else if
        if (curCount > maxCount) {
            res.clear();
            res.add(root.val);
            maxCount = curCount;
        } else if (curCount == maxCount) {
            res.add(root.val);
        }
        pre = root;
        helper(root.right);
    }

    public int[] findMode(TreeNode root) {
        helper(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
