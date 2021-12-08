package dp;

/**
 * @Description 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： F(0) = 0，F(1) = 1 F(n) = F(n - 1) + F(n - 2)，其中 n > 1 给你n ，请计算 F(n)
 * @Author Zhang Qihang
 * @Date 2021/12/8 17:47
 */
public class _509fib {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        //1. 确定dp的数组及下标的含义,dp[i]表示第i个数的fib值
        int[] dp = new int[n+1];
        //2. 确定递推公式  dp[i] = dp[i-1]+dp[i-2]
        //3. dp的初始化
        dp[0] = 0;
        dp[1] = 1;
        //4. 确定遍历顺序：从前往后遍历即可
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 举例推导
        return dp[n];
    }
}
