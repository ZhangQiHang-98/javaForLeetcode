package backTracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _46permute {
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

    public List<List<Integer>> permute(int[] nums) {
        // used默认全为false
        used = new boolean[nums.length];
        backTracing(nums);
        return res;
    }

    public static void main(String[] args) {
        _46permute solution = new _46permute();
        System.out.println(solution.permute(new int[]{1, 1, 2}));
    }
}
