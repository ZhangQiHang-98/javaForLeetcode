package backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的数字可以无限制重复被选取。
 * @Author Zhang Qihang
 * @Date 2021/9/15 22:42
 */

public class _39combinationSum {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    // 确定递归的参数以及返回值:返回值一般为void，参数如下,同样的，startIndex为从哪个数开始,sum为当前总和
    void backTracing(int[] candidates, int target, int startIndex, int sum) {
        // 回溯的终止条件：当前数字和=目标数：存，当前数字和大于目标数：返回
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        } 

        // 回溯的逻辑

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            // 直接传i就可以，不用传入i+1
            backTracing(candidates, target, i, sum);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracing(candidates, target, 0, 0);
        return res;
    }
}
