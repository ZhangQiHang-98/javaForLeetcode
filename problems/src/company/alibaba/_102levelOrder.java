package company.alibaba;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * @Author Zhang Qihang
 * @Date 2022/1/30 17:20
 */
public class _102levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < layerSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                temp.add(curNode.val);
            }
            res.add(temp);
        }
        return res;
    }
}
