package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//中序遍历
public class _94inorderTraversal {
    // 递归的写法
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

    // 迭代解法（非统一）
/*        public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 如果root为null了，说明已经走到当前的最左侧，访问结束
            // 进行处理（将对应的元素放入数组之中）
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }*/
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
