package dp;

import java.util.Arrays;

/**
 * @className: _322coinChange
 * @Description: TODO
 * @author: Zhang Qihang
 * @date: 2021/12/14 16:08
 */
public class _322coinChange {
    public static int coinChange(int[] coins, int amount) {
        //1. dp[j]表示总金额为j时，最少的硬币个数
        //2. dp[j]= Math.min(dp[j],dp[j-coins[i]]+1)
        //3. 初始化 dp[0]=0，表示总金额为0时，最少的硬币个数为0
        int[] dp = new int[amount + 1];
        // 之前不用初始化，是因为默认初始化为0了，满足题意。
        // 现在则不可以，应该初始化为代表最大值的数（在这里以amount+1代表）
        for (int j = 0; j <= amount; j++) {
            dp[j] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {

                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int amount = 11;
        int[] coins = {1, 2, 5};
        coinChange(coins, amount);
    }
}
