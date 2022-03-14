package dp;

import java.util.ArrayList;

/**
 * @className: _53maxSubArray
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author: Zhang Qihang
 * @date: 2021/12/22 21:33
 */
public class _53maxSubArray {
    public int maxSubArray(int[] nums) {
        //思路类似于贪心的思路，一定要想清楚是以nums[j]结尾还是考虑到nums[j]
        //1. dp[j]表示以nums[j]为结尾的子序和的最大值
        //2. dp[j]= Math.max(dp[j-1]+nums[j],nums[j]) 将其放入或者从当前重新开始
        //3. 初始化
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(dp[i], result);
        }
        // 将数组123456789填充到ArrayList中

        return result;
    }
}
