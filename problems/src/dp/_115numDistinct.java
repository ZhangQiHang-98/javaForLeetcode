package dp;

/**
 * @className: _115numDistinct
 * @Description: 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * @author: Zhang Qihang
 * @date: 2021/12/22 22:38
 */
public class _115numDistinct {
    public int numDistinct(String s, String t) {
        //1. dp[i][j]为s[0..i-1]出现t[0..j-1]的个数为dp[i][j]。()
        // 选还是不选，其实有点类似于背包问题
        //2. 不选择s[i]，也就是需要让s中[0,i-1]个字符去匹配t中的[0,j]字符。此时匹配值为dp[i-1][j]
        //   选择s[i]，如果s[i-1]=t[j-1]，那么dp[i][j]=dp[i-1][j-1] 如果不相等 dp[i][j]=dp[i-1][j]
        //   总结得到只有相等的时候要多加一个dp[i-1][j-1]
        //3. 初始化 dp[i][0] = 1 空字符串肯定出现1次 dp[0][j]=0 空字符串没有子串
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; //前者为选，后者为不选
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
