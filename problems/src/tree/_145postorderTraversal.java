package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _145postorderTraversal {
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

    // 如果是迭代，后序遍历为左右中，前序为中左右
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
/*    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        // 将根节点压入栈
        if (root != null) stack.push(root);
        TreeNode curr = null;
        while (!stack.isEmpty()) {   // 当栈不为空的时候
            // 得到当前栈顶的元素
            curr = stack.pop();
            // 如果当前栈顶元素不为null的话，就进行节点的添加，按照右中左的顺序，并且根据题目要求添加Null指针即可。
            if (curr != null) {
                stack.push(curr);
                stack.push(null);
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            } else {
                curr = stack.pop();
                res.add(curr.val);
            }
        }
        return res;
    }*/
}
