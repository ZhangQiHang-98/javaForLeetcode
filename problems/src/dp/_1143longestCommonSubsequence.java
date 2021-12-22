package dp;

import java.util.Arrays;

/**
 * @className: _1143longestCommonSubsequence
 * @Description: 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * @author: Zhang Qihang
 * @date: 2021/12/22 11:13
 */
public class _1143longestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        //1. dp[i][j]表示以text1[i-1]、text2[j-1]为结尾的lcs的长度
        //2. dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]) 是否+1取决于是否相等
        //3. 初始化
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        longestCommonSubsequence("abcde", "ace");
    }
}
