package tree;

import java.util.HashMap;

/**
 * @Description 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * @Author Zhang Qihang
 * @Date 2022/1/10 21:44
 */
public class _654constructMaximumBinaryTree {
    // 创建哈希表记录索引值
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] num;

    //
    public TreeNode helper(int start, int end) {
        // 走到了空节点，递归中止条件
        if (start > end) {
            return null;
        }
        // 寻找nums[start,end]中的最大值对应的索引，并赋值
        int curMaxVal = start;
        for (int i = start + 1; i <= end; i++) {
            curMaxVal = num[i] > num[curMaxVal] ? i : curMaxVal;
        }
        TreeNode node = new TreeNode(num[curMaxVal]);
        node.left = helper(start, curMaxVal - 1);
        node.right = helper(curMaxVal + 1, end);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            memo.put(nums[i], i);
        }
        num = nums;
        return helper(0, nums.length - 1);
    }
}
