package tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class _101isSynnetruc {


    // 递归方法
    // 1.确定参数与返回值，返回值为：bool类型
    // 因为要比较左右子树是否是互相反转的，所以参数为左右子树
    boolean compare(TreeNode left, TreeNode right) {
        // 2.确定终止条件，只要当前出现不相等的情况（a.一个为空一个有值，b.对应的值不相等）会返回false，否则会返回true
        if (left == null && right == null) return true;
        else if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left.val != right.val) return false;
        // 3.确定单层递归的逻辑
        // 走到此处未返回，说明左右节点均不为空且相等，这个时候比较是否对称
        boolean outSide = compare(left.left, right.right);
        boolean inSide = compare(left.right, right.left);
        // 因为是&& ,所以有一个不相等最终肯定会返回false
        return outSide && inSide;
    }

    public boolean isSymmetric_(TreeNode root) {
        if (root == null) return false;
        return compare(root.left, root.right);
    }

    // 要判断null的时候肯定是对TreeNode进行比较与判断，不可能直接存val。
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        // 第一层已经比较完了，从第二层进行比较
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            // 判断当前的节点是否相等
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            // 当前节点已经走到头了,退出当前循环
            if (leftNode == null && rightNode == null) {
                continue;
            }
            // 如果不相等，返回false
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }
        return true;
    }
}
