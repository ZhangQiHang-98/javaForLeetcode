package backTracing;/**
 * @Description
 * @Author by Zhang Qihang
 * @Date 2021/9/4 16:06
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 77题 组合
 * @Author Zhang Qihang
 * @Date 2021/9/4 16:06
 */
/*
void backtracking(参数) {
    if (终止条件) {
        存放结果;
        return;
    }

    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        处理节点;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果
    }
}
 */
public class _77combine {
    /*
     * @param: path 每条路径（1->2）
     * @param: res 最终返回结果
     * @param: n 从[1,n]的数
     * @param: k 一个组合中的元素个数
     * @param: startIndex 当前已经访问到哪个数了
     * @description: 回溯的递归函数
     * @return: void
     * @author: Zhang Qihang
     * @date: 2021/9/4
     */
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    // 确定递归的参数以及返回值:返回值一般为void，参数如下
    void backTracing(int n, int k, int startIndex) {
        // 确定终止条件：当走到叶子节点（path元素=k）
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 确定单层搜索（递归）的逻辑  (横向遍历,根据集合的大小)
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            // 本层是i的话，下一层要从i+1开始进行取值。
            backTracing(n, k, i + 1);
            // 当前迭代完成之后 往后推一位
            path.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        // startIndex从1开始
        backTracing(n, k, 1);
        return res;
    }
}
