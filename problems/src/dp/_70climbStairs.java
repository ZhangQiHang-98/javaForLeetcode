package dp;

/**
 * @Description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * @Author Zhang Qihang
 * @Date 2021/12/8 17:55
 */
public class _70climbStairs {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        //1. 明确dp数组与下标的含义  dp[i]表示有多少种方法可以到达位置i处
        int[] dp = new int[n + 1];
        //2. 确定递推公式，由于只能爬1步或者2步，因此dp[i]应该等于dp[i-1]与dp[i-2]之和
        //3. dp初始化
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        //4. 确定遍历顺序：从前往后遍历即可
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
