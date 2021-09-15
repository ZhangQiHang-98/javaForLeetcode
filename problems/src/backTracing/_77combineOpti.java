package backTracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 77题组合的优化版本
 * @Author Zhang Qihang
 * @Date 2021/9/15 21:58
 */
public class _77combineOpti {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    // 假设N=4,K=4那么第一层循环的时候，从1往后就都没有意义了，所以剪枝优化可以减少一部分搜索步骤。
    // 确定递归的参数以及返回值:返回值一般为void，参数如下
    void backTracing(int n, int k, int startIndex) {
        // 确定终止条件：当走到叶子节点（path元素=k）
        if (path.size() == k) {
            System.out.println(path);
            res.add(new ArrayList<>(path));
            return;
        }

        // 确定单层搜索（递归）的逻辑  (横向遍历,根据集合的大小)
        // 如果for循环的起始位置之后的个数已经不足元素个数了就不要了
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            // 本层是i的话，下一层要从i+1开始进行取值。
            backTracing(n, k, i + 1);
            // removeLast始终是消除当前元素
            path.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        // startIndex从1开始
        backTracing(n, k, 1);
        return res;
    }
}
