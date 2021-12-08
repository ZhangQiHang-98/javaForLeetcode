package dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * @Author Zhang Qihang
 * @Date 2021/12/8 19:08
 */
public class _746minCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        // 只要登上阶梯i，不管怎么跳，一定会消耗cost[i]的体力 也就是题目中说的爬上一个阶梯你都要花费对应的体力值
        // 1. 明确dp数组与下标的含义  dp[i]表示到达阶梯i所花费的最小体力（包含本阶梯，否则值不会变化）
        // 2. 确定递推公式  dp[i] = min(dp[i-1],dp[i-2])+cost[i]
        int len = cost.length;
        if (len <= 2) {
            return Arrays.stream(cost).min().getAsInt();
        }
        int[] dp = new int[len + 1];

        // 3. dp初始化
        dp[0] = cost[0];
        dp[1] = cost[1];
        // 4. 确定遍历顺序，从前向后推导即可
        for (int i = 2; i <= len; i++) {
            if (i == len) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]);
                break;
            }
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return dp[len];
    }
}
