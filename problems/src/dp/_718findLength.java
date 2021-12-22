package dp;

import java.util.Arrays;

/**
 * @className: _718findLength
 * @Description: 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * @author: Zhang Qihang
 * @date: 2021/12/22 10:57
 */
public class _718findLength {
    public static int findLength(int[] nums1, int[] nums2) {
        //1. dp[i][j]表示以nums1[i-1]、nums2[j-1]为结尾的子数组的最大值
        //2. dp[i][j] = dp[i-1][j-1]+1 if nums1[i]==nums2[j]
        //3. 初始化
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        int result = 0;
        //4. 遍历顺序 从左上遍历到右下即可
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return result;
    }

    // 一维滚动数组
    public static int _findLength(int[] nums1, int[] nums2) {
        //1. dp[j]表示nums2[j-1]为结尾的子数组的最大值
        //2. dp[j] = dp[j-1]+1 if nums1[i]==nums2[j]
        //3. 初始化
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] dp = new int[n2 + 1];
        int result = 0;
        //4. 遍历顺序 从左上遍历到右下即可
        for (int i = 1; i <= n1; i++) {
            for (int j = n2; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    // 不相等时要赋0，否则前面的也会落下来
                    dp[j] = 0;
                }
                result = Math.max(result, dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 4, 7};
        _findLength(nums1, nums2);
    }
}
