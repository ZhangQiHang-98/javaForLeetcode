package dp;

/**
 * @Description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * @Author Zhang Qihang
 * @Date 2021/12/8 19:42
 */
public class _62uniquePaths {
    public int uniquePaths(int m, int n) {
        //1. 明确dp含义 dp[i][j]表示到达位置(i,j)处的不同路径数。
        //2. 递推公式 dp[i][j] = dp[i-1][j]+dp[i][j-1] 记得判断是否存在
        int[][] dp = new int[m][n];
        //3. 初始化,dp[i][0]和dp[][j]一定都是1，因为只有一条路
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        //4. 确定遍历顺序，顺序遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
