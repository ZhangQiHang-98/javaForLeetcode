package greedy;

import java.util.Arrays;

/**
 * @className: _1005
 * @Description: TODO
 * @author: Zhang Qihang
 * @date: 2021/11/22 16:44
 */
public class _1005largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 先排序
        Arrays.sort(nums);
        int negatives = 0;
        boolean hasZero = false;
        // 先改负数
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] >= 0) {
                break;
            }
            nums[i] = -nums[i];
            k--;
        }
        if (k > 0) {
            Arrays.sort(nums);
            if (k % 2 == 1) {
                nums[0] = -nums[0];
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        _1005largestSumAfterKNegations test = new _1005largestSumAfterKNegations();
        int[] nums = {4, 2, 3};
        test.largestSumAfterKNegations(nums, 1);
    }
}
