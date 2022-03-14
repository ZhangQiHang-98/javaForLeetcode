package company.alibaba;

/**
 * @Description 给你一个字符串 s，找到 s 中最长的回文子串。
 * @Author Zhang Qihang
 * @Date 2022/2/1 21:46
 */
public class _5longestPalindrome {
    // dp的题目 这个应该是比较特殊的，dp的含义和最后的所求不一样
    public static int longestPalindrome(String s) {
        //1. dp的含义 dp[i][j]表示从i到j是不是一个回文子串
        //2. dp的推导 如果i==j，一个字符肯定为true,如果i==j+1,看是否相同，否则dp[i][j]==（i=j）&&(dp[i+1][j-1])
        int len = s.length();
        int res = 1;

        boolean[][] dp = new boolean[len][len];

        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        dp[i][j] = true;
                    }else if(dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j]){
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }
}
