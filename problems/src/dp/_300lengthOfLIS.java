package dp;

/**
 * @className: _300lengthOfLIS
 * @Description: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * @author: Zhang Qihang
 * @date: 2021/12/21 10:45
 */
public class _300lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        //1. dp[i]表示考虑前i个元素，以nums[i]为结尾的最长上升子序列的长度
        // 如果不一定以nums[i]结尾，考虑0101这种情况，dp会变成1223，所以一定是以nums[i]结尾才对
        // 比较的时候是把它当作结尾比的，所以dp的含义 一定是nums[i]为结尾才对
        // 主要是递推公式，要有理有据，因为多考虑了一位，所以dp为前面所有的最大那一个。
        // 最长递增子序列
        // 只考虑nums[i]>nums[j]的情况，因为如果nums[i]<nums[j]，加上当前值也不成立
        //2. dp[i] = Math.max(dp[j])+1 (0<=j<i)&&(nums[i]>nums[j])
        //3. dp[0]=1
        int[] dp = new int[n];
        int result = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
