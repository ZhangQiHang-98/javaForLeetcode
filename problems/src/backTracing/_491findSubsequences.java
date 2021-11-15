package backTracing;

import java.util.*;

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
    public void backTracing(int[] nums, int startIndex) {
        // 每次先判断path中的元素是否大于2个，是的话就填入结果
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        // 终止条件，如果index走到最后,就返回
        if (startIndex >= nums.length) {
            return;
        }
        // 因为是无序的数组，且不能进行排序，所以要设置一个set进行去重
        Set<Integer> curSet = new HashSet<>();
        //回溯逻辑：如果重复用过，或者当前值小于path的最后一个值，就继续
        for (int i = startIndex; i < nums.length; i++) {
            if (curSet.contains(nums[i]) || (path.size() > 0 && nums[i] < path.getLast())) {
                continue;
            }
            curSet.add(nums[i]);
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.removeLast();
        }

    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracing(nums, 0);
        return result;
    }

    public static void main(String[] args) {
        _491findSubsequences findSubsequences = new _491findSubsequences();
        int[] nums = {4, 4, 3, 2, 1};
        System.out.println(findSubsequences.findSubsequences(nums));
    }

}
