package dp;

/**
 * @className: _516longestPalindromeSubseq
 * @Description: 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000
 * @author: Zhang Qihang
 * @date: 2021/12/25 21:10
 */
public class _516longestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        //与647的区别是，一个是回文子串，一个是回文子序列，子序列可以进行适当的删除
        //1. dp[i][j]表示区间[i..j]（闭区间）的最长回文子序列的长度
        //2. 如果s[i]==s[j]，那么长度为dp[i+1][j-1]+2
        //   如果s[i]!=s[j]，那么要不然舍弃前面，要不然舍弃后面 dp[i][j] =Math.max(dp[i+1][j],dp[i][j-1])
        //3. 初始化，递推公式无法推导i==j的情况，因此要手动初始化
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        //4. 根据遍历顺序应该是从左下到右上
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
