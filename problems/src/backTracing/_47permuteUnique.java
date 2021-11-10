package backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _47permuteUnique {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    // 创建一个新的数组

    // 回溯函数参数：nums，因为是排列问题，所以不能用startIndex，否则没法保证全都遍历到
    // 排列的问题都要加一个used，标记元素当前是否被使用
    void backTracing(int[] nums) {
        // 终止条件
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 单层回溯逻辑
        for (int i = 0; i < nums.length; i++) {
            // !used[i - 1]表示这是同一层上的判断
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTracing(nums);
            path.removeLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 一定要记得先排序
        Arrays.sort(nums);
        // used默认全为false
        used = new boolean[nums.length];
        backTracing(nums);
        return res;
    }

    public static void main(String[] args) {
        _47permuteUnique solution = new _47permuteUnique();
        int[] nums = {3, 3, 0, 3};
        System.out.println(solution.permuteUnique(nums));
    }
}
