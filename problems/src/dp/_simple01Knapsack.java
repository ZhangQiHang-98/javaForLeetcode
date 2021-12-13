package dp;

import java.util.Arrays;

/**
 * @className: _simple01Knapsack
 * @Description: 有N件物品和一个最多能背重量为W 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 * @author: Zhang Qihang
 * @date: 2021/12/9 20:32
 */
public class _simple01Knapsack {

    public static void testWeightBagProblem(int[] weight, int[] value, int bigSize) {
        //1. dp与其下标的含义 dp[i][j]表示当负重为j时，任意考虑0~i个物品得到的最大价值
        //2. 递推公式 如果选择不拿物品i，那么dp[i][j] = dp[i-1][j](负重相同)
        // 如果拿物品i dp[i][j] = dp[i-1][j-weight[i]]+value[i]，两者取较大值即可
        // dp[i-1][j-weight[i]]表示负重为j-weight[i]时，不拿物品i的最大价值，因此选择了之后，dp[i][j]的含义就满足了
        // 也可以初始化为weight.length+1，这样行列都不用初始化了
        // 初始化为bigSize+1，所有的背包dp基本都是+1，因为是从负重为0算起比较好算。
        int[][] dp = new int[weight.length][bigSize + 1];
        //3. 初始化 dp[i][0]=0，负重为0，无法拿任何东西   tips:如果是二维的dp，一般要考虑第一行和第一列
        // 在第一列，不满足物品0负重之前，记为0，其余记为value[0]
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = weight[0]; j <= bigSize; j++) {
            dp[0][j] = value[0];
        }
        //4. 一行一行的遍历
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bigSize; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }

    // 滚动数组（一维数组）
    public static void _testWeightBagProblem(int[] weight, int[] value, int bigSize) {
        //1. dp与其下标的含义 dp[j]表示，负重为j的背包，能得到的最大价值（遍历中更新）
        //2. 递推公式 dp[j] = max(dp[j],dp[j-weight[i]]+value[i])
        int[] dp = new int[bigSize + 1];
        //3. 初始化 dp[0]永远为0,负重为0的时候永远存不了东西
        // 在第一列，不满足物品0负重之前，记为0，其余记为value[0]
        dp[0] = 0;
        //4. 遍历，内层倒序的原因是，dp[j]要根据前面的值，要保证前面的值还是上个遍历时候的值才对，所以应该倒序
        for (int i = 0; i < weight.length; i++) {
            for (int j = bigSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        _testWeightBagProblem(weight, value, bagSize);
    }
}
