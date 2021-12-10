package dp;

import java.util.Arrays;

/**
 * @Description 有一堆石头，每块石头的重量都是正整数。
 * @Author Zhang Qihang
 * @Date 2021/12/10 22:26
 */
public class _1049lastStoneWeightII {

    public static int lastStoneWeightII(int[] stones) {
        // 尽量让石头分为重量相同的两堆，这样可以使得相撞之后尽可能少。
        // 本问题可以看作是背包容量为sum/2， 价值和重量均为stone[i]的背包问题，试一试直接滚动
        int sum = 0;
        if (stones.length == 1) {
            return stones[0];
        }
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        // 1. dp含义 dp[j]表示容量为j时，能达到的最大石头重量
        // 2. 递推公式 dp[j] = max(dp[j],dp[j-stone[i]]+stone[i])
        // 3. 初始化 dp[0] = 0
        // 4. 遍历
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) { // 要不就在外面初始化，要不就i=0
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return sum - 2 * dp[target];
    }

    public static void main(String[] args) {
        int[] stone = {1, 2};
        lastStoneWeightII(stone);
    }
}
