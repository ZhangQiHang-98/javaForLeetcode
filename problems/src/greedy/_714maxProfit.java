package greedy;

/**
 * @className: _714maxProfit
 * @Description: 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * @author: Zhang Qihang
 * @date: 2021/11/30 18:02
 */
public class _714maxProfit {

    public int maxProfit(int[] prices, int fee) {
        int result = 0;
        // 最低价格，从该点买入
        int minPirce = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 情况1：如果当前值比最低价格小
            if (prices[i] < minPirce) {
                // 相当于买入
                minPirce = prices[i];
            }

            // 情况2：如果有得赚，但加上手续费亏，就持有
            if (prices[i] >= minPirce && prices[i] <= minPirce + fee) {
                continue;
            }

            //计算利润
            if (prices[i] > minPirce + fee) {
                result += prices[i] - minPirce - fee;
                minPirce = prices[i] - fee;  // 继续收获利润
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _714maxProfit test = new _714maxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        // System.out.println(test.maxProfit(prices));
    }
}
