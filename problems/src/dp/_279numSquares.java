package dp;

/**
 * @className: _279numSquares
 * @Description: 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * @author: Zhang Qihang
 * @date: 2021/12/15 10:44
 */
public class _279numSquares {
    public static int numSquares(int n) {
        int lastNum = (int) Math.floor(Math.sqrt(n));
        int[] nums = new int[lastNum];
        for (int i = 0; i < lastNum; i++) {
            nums[i] = (i + 1) * (i + 1);
        }
        //1. dp[j]表示在正整数j下，组成个数最小的值
        //2. dp[j]=Math.min(dp[j],dp[j-nums[i]]+1)
        //3. 初始化，先将dp都初始化为一个较大值(n+1),dp[0]=0，个数为0，和为0
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = n + 1;
        }
        dp[0] = 0;
        //4. 遍历即可
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= n; j++) {
                dp[j]=Math.min(dp[j],dp[j-nums[i]]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(24));
    }
}
