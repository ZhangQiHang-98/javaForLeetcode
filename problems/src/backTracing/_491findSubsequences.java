package backTracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * @Author Zhang Qihang
 * @Date 2021/11/9 19:59
 */
public class _491findSubsequences {
    // 存储结果
    public static List<List<Integer>> result = new ArrayList<>();
    public static LinkedList<Integer> path = new LinkedList<>();

    // 回溯参数，常见回溯参数即可
    public void backTracing(int[] nums, int startIndex, int flag) {
        System.out.println(startIndex);
        // 终止条件，如果(当前走到的值比path中的要小||走到最后)且长度>=2
        if (path.size() >= 2 && (startIndex >= nums.length || nums[startIndex] < path.getLast())) {
            System.out.println(path);
            result.add(path);
            return;
        }
        if (flag == 0) {
            //回溯逻辑
            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
                backTracing(nums, i + 1, 1);
                path.removeLast();
            }
        } else {
            path.add(nums[startIndex]);
            backTracing(nums, startIndex + 1, 1);
            path.removeLast();
        }

    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracing(nums, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        _491findSubsequences solution = new _491findSubsequences();
        int[] nums = {4, 6, 7, 7};
        solution.findSubsequences(nums);
    }
}
