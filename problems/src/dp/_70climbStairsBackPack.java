package dp;

import java.util.Arrays;

/**
 * @className: _70climbStairsBackPack
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
 * @author: Zhang Qihang
 * @date: 2021/12/14 16:01
 */
public class _70climbStairsBackPack {
    public static int climbStairs(int n) {
        // 此处的nums={1，2}
        //1. dp[j]j阶台阶共有多少种爬法
        //2. dp[j] += dp[j-num[i]]
        //3. 初始化dp
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] nums = {1, 2};
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
