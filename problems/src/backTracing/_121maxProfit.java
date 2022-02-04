package backTracing;

import java.util.Arrays;

/**
 * @Description 买卖股票的最佳时机
 * @Author Zhang Qihang
 * @Date 2022/2/2 22:43
 */
public class _121maxProfit {
    public int maxProfit(int[] prices) {
        // 1. dp[i][0]表示第i天买入（保持）的最大利润，dp[i][1]表示卖出~
        // 2. dp[i][0] = max(dp[i-1][0],-prices[i])之前就买了，今天才买
        //    dp[i][1] = max(dp[i-1][1],dp[i-1][0]+prices[i])之前就已经卖出了，今天卖出
        int[][] dp = new int[prices.length][2];
        // 3. 初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    public int _maxProfit(int[] prices) {
        //记录最左侧的最小值
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }
}
