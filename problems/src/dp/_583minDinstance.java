package dp;

/**
 * @className: _583minDinstance
 * @Description: 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * @author: Zhang Qihang
 * @date: 2021/12/24 14:18
 */
public class _583minDinstance {
    public int minDistance(String word1, String word2) {
        //1. dp[i][j]表示使串1[0..i-1]与串2[0..j-1]相同所需的最小步数
        //2. 如果word1[i-1]==word2[i-1] dp[i][j]=dp[i-1][j-1]
        //   如果!=，要么删掉字符word1[i-1]，这样dp[i][j]=dp[i-1][j] +1， 要么删掉word2[j-1]
        //   这样 dp[i][j] = dp[i][j-1]+1
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
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

}
