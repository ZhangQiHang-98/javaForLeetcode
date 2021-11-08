package backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @Author Zhang Qihang
 * @Date 2021/11/8 22:50
 */
public class _78subsets {

    // 结果参数
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    // 回溯参数：nums，startIndex
    public void backTracing(int[] nums, int startIndex) {
        // 先将空的和本身都放进去
        res.add(new ArrayList<>(path));
        // 确定终止条件，横向选择也是减少，纵向选择也是减少，要明确终止条件
        if (startIndex >= nums.length) {
            return;
        }
        //单层回溯的逻辑
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.removeLast();
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        backTracing(nums, 0);
        return res;
    }
}
