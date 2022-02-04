package company.alibaba;

import java.util.Arrays;

/**
 * @Description 找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @Author Zhang Qihang
 * @Date 2022/2/3 15:38
 */
public class _64minPathSum {
    // 一看就是典型的dp问题
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        //1. dp的含义 dp[i][j]表示在位置(i,j)处的最短路径
        //2. dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j]
        //3. 初始化，如果不多开一行一列，要自己初始化第一行和第一列
        int[][] dp = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            count += grid[i][0];
            dp[i][0] = count;
        }
        count = 0;
        for (int j = 0; j < grid[0].length; j++) {
            count += grid[0][j];
            dp[0][j] = count;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[grid.length - 1][grid[0].length - 1 ];
    }

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3}, {4, 5, 6}};
        minPathSum(a);
    }
}
