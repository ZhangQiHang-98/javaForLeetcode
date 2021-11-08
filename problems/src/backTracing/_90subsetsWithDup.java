package backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @Author Zhang Qihang
 * @Date 2021/11/8 23:22
 */
public class _90subsetsWithDup {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public void backTracing(int[] nums, int startIndex) {

        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.removeLast();
        }

    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 去重问题首先要排序
        Arrays.sort(nums);
        backTracing(nums, 0);
        return res;
    }
}
