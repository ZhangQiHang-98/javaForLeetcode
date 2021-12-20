package dp;

/**
 * @className: _123maxProfit
 * @Description: 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * @author: Zhang Qihang
 * @date: 2021/12/19 17:50
 */
public class _123maxProfit {
    public int maxProfit(int[] prices) {
        // 一共有5个状态：0. 没有操作 1.第一次买入 2.第一次卖出 3.第二次买入 4.第二次卖出
        //1. dp[i][j]表示第i天状态j下的最大利润
        //2. dp[i][1]表示第i天，仍处在第一次买入的状态，并不是一定要在第i天买
        // dp[i][0] = dp[i - 1][0];
        // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        // dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + price[i]);
        // dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - price[i]);
        // dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        //3. 初始化：dp[0][0]=0 dp[0][1]=-price[0] dp[0][2]=0 dp[0][3]=-price[0] dp[0][4] =0
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}
