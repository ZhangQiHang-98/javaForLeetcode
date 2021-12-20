package dp;

/**
 * @className: _122maxProfit
 * @Description: 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * @author: Zhang Qihang
 * @date: 2021/12/19 17:29
 */
public class _122maxProfit {
    public int maxProfit(int[] prices) {
        // 不能一天既买又卖，那么每天只有两个状态（有\没有股票）
        //1. dp[i][0]表示第i天没有股票时的最大利润  dp[i][1]表示第i天持有股票时的最大利润
        //2. 如果第i-1天持有，那么dp[i][0] = dp[i-1][1]+price[i] 如果不持有 那么dp[i][0]=dp[i-1][0]
        //   如果第i-1天持有，那么dp[i][1]=dp[i-1][1] 如果不持有 那么dp[i][1]=dp[i-1][0]-price[i]
        //3. 初始化 dp[0][0] = 0  dp[0][1]= -price[0]
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
