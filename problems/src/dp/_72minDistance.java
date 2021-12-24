package dp;

/**
 * @Description 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * @Author Zhang Qihang
 * @Date 2021/12/24 14:58
 */
public class _72minDistance {
    public int minDistance(String word1, String word2) {
        //1. dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
        //2. 如果word1[i-1] == word2[j-1] 那么dp[i][j] = dp[i-1][j-1]，否则进行增删改操作
        //   删除：word1删掉一个元素 那dp[i][j]=dp[i-1][j]+1。word2删掉一个元素 那dp[i][j]=dp[i][j-1]
        //   增加：删除与增加时等价的 例如 A doge B dog 既可以A删除e，又可以B增加e
        //   替换: 将当前替换成一样的，相当于在相等的基础上多操作了一步 dp[i][j] = dp[i-1][j-1]+1
        //3. 初始化 dp[0][j]与dp[i][0]分别为j和0，表示空字符串和长度为i(j)的字符串的情况
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
