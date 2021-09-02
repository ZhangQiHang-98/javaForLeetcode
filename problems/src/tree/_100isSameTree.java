package tree;

import java.util.*;

public class _100isSameTree {

    // 1.递归函数的参数与返回值:参数为两个节点的左子树、右子树，返回值为是否相等
    public boolean helper(TreeNode node1, TreeNode node2) {
        // 终止条件，如果不相等了就退出
        if (node1 == null && node2 == null) return true;
        else if (node1 == null && node2 != null) return false;
        else if (node1 != null && node2 == null) return false;
        else if (node1.val != node2.val) return false;
        // 当前值相等时，前序遍历（先处理判断了当前节点，然后遍历子节点）
        boolean leftSame = helper(node1.left, node2.left);
        boolean rightSame = helper(node1.right, node2.right);
        return leftSame && rightSame;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }

}
