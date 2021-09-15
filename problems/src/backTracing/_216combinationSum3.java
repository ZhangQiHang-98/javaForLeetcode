package backTracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * @Author Zhang Qihang
 * @Date 2021/9/15 22:11
 */
public class _216combinationSum3 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    // 确定递归的参数以及返回值:返回值一般为void，参数如下,同样的，startIndex为从哪个数开始,sum为当前总和
    void backTracing(int n, int k, int startIndex, int sum) {
        //剪枝
        if (sum > n) {
            return;
        }
        //确定终止条件
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        //确定单层逻辑，横向遍历
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracing(n, k, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracing(n, k, 1, 0);
        return res;
    }


}
