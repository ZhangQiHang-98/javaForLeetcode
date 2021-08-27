package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 先序遍历
public class _144preorderTraversal {
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

    // 正常递归写法
/*    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        helper(node.left, res);
        helper(node.right, res);
    }*/

    // 先序遍历 迭代的常规解法 容易想到，但是不容易与其他两个遍历情况统一
/*    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        return res;
    }*/

    // 前序、中序、后序三种遍历方式都是先调用node.left再调用node.right，本质上都是先遍历到二叉树的最左子节点
/*    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return res;

        TreeNode node = root;
        // 如果同时stack为空且node为null时，说明已经遍历结束了
        while (!stack.isEmpty() || node != null) {
            while (node != null) { //先使root指向当前子二叉树的最左节点
                stack.push(node);
                res.add(node.val);
                node = node.left;
            }
            // 分别从最左子节点开始访问当前节点的右子树，直到根节点为空
            node = stack.pop();
            node = node.right;
        }
        return res;
    }*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        // 将根节点压入栈
        if (root != null) stack.push(root);
        TreeNode curr = null;
        while (!stack.isEmpty()) {   // 当栈不为空的时候
            // 得到当前栈顶的元素
            // 有一个先出栈再进的过程，避免重复操作
            curr = stack.pop();
            // 如果当前栈顶元素不为null的话，就进行节点的添加与遍历，按照右中左的顺序，并且根据题目要求添加Null指针即可。

            if (curr != null) {
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
                stack.push(curr);
                stack.push(null);
            } else { //当前节点是要处理的节点了，就进行处理
                // 先把空节点弹出
                stack.pop();
                curr = stack.pop();
                res.add(curr.val);
            }
        }
        return res;
    }
}
