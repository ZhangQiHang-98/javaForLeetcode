package greedy;

/**
 * @Description 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。返回利润的最大值
 * @Author Zhang Qihang
 * @Date 2021/11/29 17:06
 */
public class _714maxProfit {
    public int maxProfit(int[] prices, int fee) {
        int result = 0;
        // 买入点
        int bugIn = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            // 上坡起点，买入。上坡中间，继续。
            if (prices[i] < prices[i + 1] && bugIn < 0) {
                bugIn = prices[i];
            }
            // 当前是峰值,且收益比手续费贵，卖出
            if (prices[i] > prices[i + 1] && bugIn >= 0 && (prices[i] - bugIn > fee)) {
                bugIn = prices[i] - bugIn;
                result += (bugIn - fee);
                bugIn = -1;
            }
        }
        // 单独处理最后一个值
        if (bugIn >= 0) {
            result += (prices[prices.length - 1] - bugIn - fee);
        }
        return result;
    }

    public static void main(String[] args) {
        _714maxProfit test = new _714maxProfit();
        int[] prices = {1,3,7,5,10,3};
        System.out.println(test.maxProfit(prices, 3));
    }
}
