package dp;

/**
 * @className: _714maxProfit
 * @Description: 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * @author: Zhang Qihang
 * @date: 2021/12/20 11:00
 */
public class _714maxProfit {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        // 一共有两个状态，0 买入（当天或保持）、1 卖出（当天或保持）
        // 我们规定在卖出的时候交手续费，只有卖出才表示一手交易已经结束
        //1. dp[i][j]表示第i天状态j下的最大利润
        //2. dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]-fee)
        //   dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i])
        //3. 初始化
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[n - 1][1];
    }
}
