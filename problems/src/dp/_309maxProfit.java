package dp;

/**
 * @className: _309maxProfit
 * @Description: 设计一个算法计算出最大利润。含冷冻期，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * @author: Zhang Qihang
 * @date: 2021/12/19 18:20
 */
public class _309maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 我们分为4个状态 0. 买入（当天买入、保持买入） 1. 卖出（已过冷冻期，保持） 2. 卖出（当天） 3.冷冻期（当天）
        //1. dp[i][j]表示第i天处于第j个状态时的最大利润
        //2. dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i],dp[i-1][3]-prices[i])
        //   dp[i][1] = Math.max(dp[i-1][1],dp[i-1][3]) 已过冷冻期，说明前一天不可能为状态1
        //   dp[i][2] = Math.max(dp[i-1][0]+prices[i])
        //   dp[i][3] = Math.max(dp[i-1][2])
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][1],Math.max(dp[prices.length-1][2],dp[prices.length-1][3]));
    }
}
