package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94inorderTraversal {
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

/*    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }*/

    //    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//
//        while (root != null || !stack.isEmpty()) { // 如果同时stack为空且node为null时，说明已经遍历结束了
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            res.add(root.val);
//            root = root.right;
//        }
//        return res;
//    }
    //根据代码随想录得到的统一的解法
    public List<Integer> inorderTraversal(TreeNode root) {
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
                if (curr.right != null) stack.push(curr.right);
                stack.push(curr);
                stack.push(null);
                if (curr.left != null) stack.push(curr.left);
            } else {
                curr = stack.pop();
                res.add(curr.val);
            }
        }
        return res;
    }
}
