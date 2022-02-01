package company.alibaba;

/**
 * @Description 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @Author Zhang Qihang
 * @Date 2022/1/31 12:29
 */
// 应该是三种方法都可以，贪心、DP、分治
public class _53maxSubArray {
    public int maxSubArray(int[] nums) {
        //1. dp[j]表示以j为结尾的最大子序和
        //2. dp[j]= max(dp[j-1]+nums[i],nums[i])
        int len = nums.length;
        int[] dp = new int[len];
        //3. 初始化dp[0]就行了吧
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
