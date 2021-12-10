package dp;

/**
 * @Description 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * @Author Zhang Qihang
 * @Date 2021/12/10 23:41
 */
public class _494findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        // 在动态规划里，只考虑一点一点往上填，如果既可以增加，又可以减少，优先考虑怎么只转换为增加
        // 首先要将问题合理的转换为0-1背包的问题，即首先要考虑，背包总量是多少，价值和重量怎么表示
        // 假设加的总和为x，那么减的总和为sum-x 那么需要满足 x-(sum-x) = target  因此 x = (target+sum)/2
        // 也就是找能正好装满x的背包有多少种方法即可
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum || (target + sum) % 2 == 1) {
            return 0;
        }
        int add = Math.abs((target + sum) / 2);

        //1. dp下标及其含义 dp[j]表示和为j的方法数
        //2. 递推公式 dp[j]= dp[j]+dp[j-nums[i]]; 不用i有前面这些方法，用了i又多了一些方法
        //3. 初始化 dp[0] = 0
        int[] dp = new int[add + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = add; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[add];
    }
}
