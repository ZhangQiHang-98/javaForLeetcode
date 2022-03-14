package dp;

import java.util.Arrays;

/**
 * @className: _518change
 * @Description: 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * @author: Zhang Qihang
 * @date: 2021/12/13 22:14
 */
public class _518change {
    public static int change(int amount, int[] coins) {
        //1. dp的含义 dp[j]表示总金额为j时，硬币的组合数
        //2. 递推公式 dp[j] = dp[j] + dp[j-coins[i]]
        //3. 初始化 只有当不选取任何硬币时，金额之和才为 0，因此只有1种硬币组合。
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 3;
        int[] coins = {1, 2};
        change(amount, coins);
    }
}
