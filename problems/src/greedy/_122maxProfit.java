package greedy;

/**
 * @className: _maxProfit
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
 * @author: Zhang Qihang
 * @date: 2021/11/19 11:13
 */
public class _122maxProfit {
    // 贪心算法：如果当前点处于下坡起点，就不买入，如果当前点处于上坡起点，就买入
    // 局部最优：保证每次交易都是上坡起点买，上坡终点卖，然后等待下一个上坡起点
    public int maxProfit(int[] prices) {
        int result = 0;
        // 买入点
        int bugIn = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            // 上坡起点，买入。上坡中间，继续。
            if (prices[i] < prices[i + 1] && bugIn < 0) {
                bugIn = prices[i];
            }
            // 当前是峰值,卖出
            if (prices[i] > prices[i + 1] && bugIn >= 0) {
                bugIn = prices[i] - bugIn;
                result += bugIn;
                bugIn = -1;
            }
        }
        // 单独处理最后一个值
        if (bugIn >= 0) {
            result += prices[prices.length - 1] - bugIn;
        }
        return result;
    }

    // 贪心算法：利润分解，比如1买3卖变成  3-2 + 2-1
    public int maxProfit1(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }

    public static void main(String[] args) {
        _122maxProfit test = new _122maxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(test.maxProfit(prices));
    }
}
