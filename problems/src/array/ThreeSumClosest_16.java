package array;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    // 初始方法，套用了前面简单的三数之和
    // cur_diff是差值，每次如果差值变小，就会刷新记录当前的三数之和
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        int cur_diff = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int another_sum = target - nums[i];
            int j = i + 1, k = len - 1;
            while (j < k) {
                if (cur_diff > Math.abs(another_sum - (nums[j] + nums[k]))) {
                    res = nums[i] + nums[k] + nums[j];
                    cur_diff = Math.abs(another_sum - (nums[j] + nums[k]));
                }
                if (nums[k] + nums[j] < another_sum) {
                    j++;
                } else if(nums[k] + nums[j] > another_sum){
                    k--;
                } else { // 添加一个直接提交
                    return target;
                }
            }
        }
        return res;
    }
}
