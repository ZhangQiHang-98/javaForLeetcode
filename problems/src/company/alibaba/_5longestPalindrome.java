package company.alibaba;

/**
 * @Description 给你一个字符串 s，找到 s 中最长的回文子串。
 * @Author Zhang Qihang
 * @Date 2022/2/1 21:46
 */
public class _5longestPalindrome {
    // dp的题目 这个应该是比较特殊的，dp的含义和最后的所求不一样
    public static String longestPalindrome(String s) {
        //1. dp的含义 dp[i][j]表示从i到j是不是一个回文子串
        //2. dp的推导 如果i==j，一个字符肯定为true,如果i==j+1,看是否相同，否则dp[i][j]==（i=j）&&(dp[i+1][j-1])
        int len = s.length();
        int result = 0;

        int start = 0;

        boolean[][] dp = new boolean[len][len];
        //3. 初始化  对角线和对角线上面一行初始化为true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        //4. 遍历顺序，左下推右上，这里j要从i开始，因为区间是[i,j]
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // 判断三种情况
                if (s.charAt(i) == s.charAt(j) && i != j) {
                    dp[i][j] = dp[i + 1][j - 1] || dp[i][j];
                }
                // 计算最大值
                if (dp[i][j] == true) {
                    if (j - i + 1 > result) {
                        result = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        System.out.println(start);
        System.out.println(result);
        return s.substring(start, start + result);
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }
}
