package company.codeTop;

/**
 * @className: _300lengthOfLIS
 * @Description: 最长递增子序列
 * @author: Zhang Qihang
 * @date: 2022/3/22 11:47
 */
public class _300lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        // dp[i]表示以i为结尾的最长递增子序列的大小
        // dp[i] = Math.max(dp[j]) + 1
        int len = nums.length;
        int res = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
