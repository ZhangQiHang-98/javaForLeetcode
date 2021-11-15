package backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的每个数字在每个组合中只能使用一次。
 * @Author Zhang Qihang
 * @Date 2021/9/23 22:25
 */
public class _40combinationSum2 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    void backTracing(int[] candidates, int target, int startIndex, int sum) {
        // 回溯的终止条件：当前数字和=目标数：存，当前数字和大于目标数：返回
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 去重操作，必须要先排序
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTracing(candidates, target, i + 1, sum);
            sum -= candidates[i];
            path.removeLast();
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracing(candidates, target, 0, 0);
        return res;
    }
}
