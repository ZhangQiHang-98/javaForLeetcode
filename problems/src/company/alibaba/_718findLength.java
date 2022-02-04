package company.alibaba;

/**
 * @Description 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * @Author Zhang Qihang
 * @Date 2022/2/4 19:44
 */
public class _718findLength {
    // 尝试用dp来解
    public int findLength(int[] nums1, int[] nums2) {
        //1. dp[i][j]表示以nums1[i-1] nums2[j-1]为结尾的子数组长度
        //2. dp[i][j] = 如果i==j那么等于dp[i-1][j-1]+1，否则等于dp[i][j]=0
        int res = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
