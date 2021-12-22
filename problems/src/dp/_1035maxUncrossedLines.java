package dp;

/**
 * @className: _1035maxUncrossedLines
 * @Description: 以这种方法绘制线条，并返回我们可以绘制的最大连线数。
 * @author: Zhang Qihang
 * @date: 2021/12/22 11:45
 */
public class _1035maxUncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
