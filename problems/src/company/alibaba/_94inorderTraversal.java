package company.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 中序遍历
 * @Author Zhang Qihang
 * @Date 2022/1/30 17:30
 */
public class _94inorderTraversal {
    List<Integer> res = new ArrayList<>();

    // 最简单的递归方法
    public List<Integer> inorderTraversal1(TreeNode root) {
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        // 单层递归逻辑
        res.add(root.val);
        helper(root.right);
    }

    // 非统一的写法
    // 利用栈，但是入栈的时候只能是先处理当前节点（先序的顺序），但是这里要先处理左节点，所以要做特殊处理
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                // 处理左节点
                stack.push(root);
                root = root.left;
            } else {
                // 当前节点为空，说明左边走到头了，当前栈存的是最左侧的值
                TreeNode temp = stack.pop();
                // 进行输出
                res.add(temp.val);
                // 处理右节点
                root = temp.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            // 永远是先弹栈一个出来看，判断其是否为空节点
            TreeNode node = stack.pop();
            if (node != null) {
                // 说明是正常的元素，按顺序进行放入即可,注意入栈顺序
                // 如果是叶子结点的话，也要推1个null进去。
                if (root.right != null) {
                    stack.push(root.right);
                }
                stack.push(root);
                stack.push(null);
                if (root.left != null) {
                    stack.push(root.left);
                }
            } else {
                //再推一个出来
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}
