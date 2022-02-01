package company.alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * @Author Zhang Qihang
 * @Date 2022/1/30 16:08
 */
public class _15threeSum {

    //使用双指针方法，能够让复杂度降到O(n2)，记得先排序
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            // 可能产生重复解，单独处理
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // 从第一个元素开始找
            int remian = -nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                // 如果找到了合适的解
                if (nums[left] + nums[right] == remian) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 如果下一个数和当前数一样，也会产生重复解
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 此时到了最后一个重复的地方，然后再++--操作
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < remian) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        // 一种方法可以得到结果再去重，另一种方法则是在过程中进行去重。
        return res;
    }

}
