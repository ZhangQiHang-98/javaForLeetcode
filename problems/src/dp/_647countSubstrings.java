package dp;

/**
 * @Description 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * @Author Zhang Qihang
 * @Date 2021/12/24 16:39
 */
public class _647countSubstrings {
    public int countSubstrings(String s) {
        // 遇到的第一个Dp和结果完全分开的
        //1. dp[i][j]表示区间[i,j]的串是否为回文串
        //2. 如果s[i]!=s[j]，那么肯定不是回文串
        //   如果s[i]==s[j] a. i==j 肯定是  b. i+1==j 也是  c.else dp[i][j]=dp[i+1][j-1]
        //3. 初始化
        int len = s.length();
        int result = 0;
        boolean[][] dp = new boolean[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || i + 1 == j) {
                        dp[i][j] = true;
                        result++;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i + 1][j - 1]) {
                            result++;
                        }
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return result;
    }
}
