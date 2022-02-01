package company.alibaba;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 给定一个不含重复数字的数组nums ，返回其所有可能的全排列 。你可以按任意顺序返回答案。
 * @Author Zhang Qihang
 * @Date 2022/2/1 21:10
 */
public class _46permute {
    List<List<Integer>> res = new ArrayList<>();
    // 因为path要删掉最后一个元素，所以用链表好一点
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backTracing(nums);
        return res;
    }

    // 在这里不能返回used，要不然每次都会传一个新的
    // 模板的返回值以及参数
    public void backTracing(int[] nums) {
        // 回溯函数的中止条件
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 回溯遍历的过程
        for (int i = 0; i < nums.length; i++) {
            // 弹入
            if (used[i] == true) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTracing(nums);
            // 弹出
            path.removeLast();
            used[i] = false;
        }
    }
}
