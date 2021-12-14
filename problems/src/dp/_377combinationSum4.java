package dp;

/**
 * @className: _377combinationSum4
 * @Description: 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * @author: Zhang Qihang
 * @date: 2021/12/14 15:46
 */
public class _377combinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        //1. dp[j]表示和为j时的组合个数
        //2. dp[j]= dp[j] + dp[j-nums[i]]
        //3. 初始化,dp[0]=1，只有当不选取任何元素时，元素之和才为0，因此只有 11 种方案。
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //4. 遍历顺序，审题可知，目标是求排列，因此应该先遍历背包，再遍历物品
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
