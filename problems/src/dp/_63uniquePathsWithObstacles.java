package dp;

import java.util.Arrays;

/**
 * @className: _63uniquePathsWithObstacles
 * @Description: 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * @author: Zhang Qihang
 * @date: 2021/12/9 10:40
 */
public class _63uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // m为行，n为列
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //1. 明确dp含义 dp[i][j]表示到达位置(i,j)处的不同路径数。
        //2. 递推公式 dp[i][j] = dp[i-1][j]+dp[i][j-1] 记得判断是否存在
        int[][] dp = new int[m][n];
        //3. 初始化,dp[i][0]和dp[][j]一定都是1，因为只有一条路。如果路上有障碍，之后的置为0
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        System.out.println(Arrays.deepToString(dp));
        //4. 确定遍历顺序，顺序遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        _63uniquePathsWithObstacles test = new _63uniquePathsWithObstacles();
        int a[][] = {{1, 1}, {0, 0}, {0, 0}};
        test.uniquePathsWithObstacles(a);
    }
}
