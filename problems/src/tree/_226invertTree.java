package tree;

import java.util.LinkedList;
import java.util.Queue;

public class _226invertTree {

    // 层序遍历的方法
    public TreeNode invertTree(TreeNode root) {
        // 记得加一个root为空直接返回
        if (root == null) {
            return null;
        }
        // 自上而下，每一个节点的左右子树都反转即可，前序遍历、后序遍历、层序遍历都可以
        TreeNode curNode = new TreeNode();
        TreeNode temp = new TreeNode();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            // 左右子树进行交换
            temp = curNode.left;
            curNode.left = curNode.right;
            curNode.right = temp;
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    // 利用递归方法对二叉树进行反转，递归函数对当前节点的左右子树分别进行反转
    // 前中后序在这里代表对当前节点的处理顺序，当前用的是后序，因为是先对左右进行遍历，然后再对当前进行处理。
    //1.确定参数与返回值:参数为当前的节点，因为要返回root节点的指针，因此返回类型也为TreeNode
    public TreeNode _invertTree(TreeNode root) {
        // 2.确定终止条件：如果当前节点为空，就返回
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        //3. 单层逻辑
        swapChildren(root);
        return root;
    }
}
