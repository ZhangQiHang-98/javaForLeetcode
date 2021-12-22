package dp;

/**
 * @className: _392isSubsequence
 * @Description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * @author: Zhang Qihang
 * @date: 2021/12/22 22:07
 */
public class _392isSubsequence {
    public static boolean isSubsequence(String s, String t) {
        // 比较简单的方法：双指针法
        int ps = 0;
        int pt = 0;
        if (s.length() == 0) {
            return true;
        }
        while (pt < t.length() && ps < s.length()) {
            // 匹配上了
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
                pt++;
            } else {
                pt++;
            }
        }
        if (ps == s.length()) {
            return true;
        }
        return false;
    }

    public static boolean _isSubsequence(String s, String t) {
        // 动态规划的方法
        //1. dp[i][j] s[0..i]是否是t[0..j]的子序列
        //2. 如果s[i]=s[j]，那么dp[i][j]= dp[i-1][j-1]
        //   如果不相等，那么dp[i][j]= dp[i][j-1]
        //3. 初始化的时候，多初始化一行一列，置为false，将s中第一个字母出现在t中的位置记为true
        if (s.length() == 0) {
            return true;
        }
        int sLen = s.length();
        int tLen = t.length();
        boolean[][] dp = new boolean[sLen + 1][tLen + 1];
        for (int i = 0; i < tLen; i++) {
            if (s.charAt(0) == t.charAt(i)) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[sLen][tLen];
    }

    public static void main(String[] args) {
        isSubsequence("b", "abc");
    }
}
