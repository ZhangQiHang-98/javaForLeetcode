package dp;

/**
 * @className: _343integerBreak
 * @Description: 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * @author: Zhang Qihang
 * @date: 2021/12/9 11:25
 */
public class _343integerBreak {
    public int integerBreak(int n) {
        //1. dp数组及下标的含义，拆分数字i，可以得到的最大乘积
        //j*(i-j)代表把i拆分为j和i-j两个数相乘
        //j*dp[i-j]代表把i拆分成j和继续把(i-j)这个数拆分，取(i-j)拆分结果中的最大乘积与j相乘
        //2. 确定递推公式 dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
        int[] dp = new int[n + 1];
        //3. 初始化 dp[2] =1
        dp[2] = 1;
        //4. 确定遍历顺序
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                // 更新dp[i]的值，所以才要加一个dp[i]
                // j<i-1，就保证了dp[i-j]不会取到dp[1]
                // 这里其实模拟的是拆分过程，拆两个，拆三个，一直到拆n个
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
