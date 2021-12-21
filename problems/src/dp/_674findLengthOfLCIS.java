package dp;

/**
 * @className: _674
 * @Description: 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * @author: Zhang Qihang
 * @date: 2021/12/21 11:18
 */
public class _674findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        //1. dp[i]表示以i为结尾的连续递增子序列的最大值
        //2. dp[i] = dp[i-1]+1 nums[i]>nums[i-1]
        //3. dp[0] = 1
        int[] dp = new int[n];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
