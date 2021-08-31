package tree;

import java.util.LinkedList;
import java.util.Queue;

public class _226invertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
}
