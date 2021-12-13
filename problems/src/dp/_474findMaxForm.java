package dp;

/**
 * @className: _474findMaxForm
 * @Description: 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * @author: Zhang Qihang
 * @date: 2021/12/13 20:30
 */
public class _474findMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        // 如果元素为长度+1，第一个就代表什么都不考虑，这样可以不用单独想初始化的问题
        //正常的背包有一个限制条件即重量，那j就取[0,weight]即可，此题有两个限制条件，那么最原始的应该是个三维背包
        //1. dp[i][j][k]表示考虑前0~i个元素，最多有j个0，m个1的时候 最大子集的个数
        //2. dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-zeroSum][k-oneSum]+1)
        // zeroSum和oneSum代表第i个元素中的0和1的个数
        //3. 初始化dp
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        // 进行遍历
        for (int i = 1; i <= strs.length; i++) {
            int[] temp = getZerosOnes(strs[i - 1]);
            int zero = temp[0];
            int one = temp[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zero && k >= one) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zero][k - one] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    // 滚动数组
    public int _findMaxForm(String[] strs, int m, int n) {
        //1. 含义 dp[i][j]代表i个0，j个1时候的最大子集
        //2. dp[i][j] = max(dp[i][j],dp[i-zero][j-one]+1)
        //3. 初始化
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int[] temp = getZerosOnes(strs[i]);
            int zero = temp[0];
            int one = temp[1];
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }
}
