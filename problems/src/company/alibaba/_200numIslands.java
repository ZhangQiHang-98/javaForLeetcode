package company.alibaba;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * @Author Zhang Qihang
 * @Date 2022/2/2 18:04
 */


/*      0 —— 海洋格子
        1 —— 陆地格子（未遍历过）
        2 —— 陆地格子（已遍历过）*/
public class _200numIslands {
    // 计算岛屿数目
    public int numIslands(char[][] grid) {
        int num_islands = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num_islands++;
                }
            }
        }
        return num_islands;
    }

    // 计算岛屿面积
    public int maxAreaOfIsland(char[][] grid) {
        // 这里没啥区别，在dfs中，变成+就可，然后res一直Math.max
        return 0;
    }

    // 填海造陆
    public int largestIsland(int[][] grid) {
        // 第一步：先计算岛屿面积，然后在所有的岛屿格子上标记出其属于哪个岛屿
        // 第二步：遍历海洋，找到相邻陆地面积最大的海洋格子
        // 索引从2开始，0是海洋，1是陆地
        int index = 2;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        //第一步
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = area(grid, i, j, index);
                    map.put(index, area);
                    index++;
                    // 先记录当前最大值，如果最特殊情况，全为陆地，可能能用到
                    res = Math.max(res, area);
                }
            }
        }

        // 第二步
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> hashSet = new HashSet<>();
                    hashSet = findNeighbour(grid, i, j);
                    // 如果当前集合里没有值，说明是孤零零海洋，跳过
                    if (hashSet.size() == 0) {
                        continue;
                    }
                    int sum = 1;
                    for (Integer item : hashSet) sum += map.get(item);
                    res = Math.max(res, sum);
                    // 先记录当前最大值，如果最特殊情况，全为陆地，可能能用到
                }
            }
        }
        return res;
    }

    private Set<Integer> findNeighbour(int[][] grid, int r, int c) {
        Set<Integer> hashSet = new HashSet<>();
        if (inArea(grid, r - 1, c) && grid[r - 1][c] != 0)
            hashSet.add(grid[r - 1][c]);
        if (inArea(grid, r + 1, c) && grid[r + 1][c] != 0)
            hashSet.add(grid[r + 1][c]);
        if (inArea(grid, r, c - 1) && grid[r][c - 1] != 0)
            hashSet.add(grid[r][c - 1]);
        if (inArea(grid, r, c + 1) && grid[r][c + 1] != 0)
            hashSet.add(grid[r][c + 1]);
        // hashSet存储的是这片海洋临近哪些岛屿
        return hashSet;
    }

    private int area(int[][] grid, int r, int c, int index) {
        if (!inArea(grid, r, c)) return 0;
        if (grid[r][c] != 1) return 0;
        grid[r][c] = index;
        return 1 + area(grid, r - 1, c, index) + area(grid, r + 1, c, index) + area(grid, r, c - 1, index) + area(grid, r, c + 1, index);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    public void dfs(char[][] grid, int row, int col) {
        // 边界条件的判断
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
            return;
        }
        // 如果当前是海洋或者是遍历过的陆地，就返回
        if (grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    // 周长
    int dfs(int[][] grid, int r, int c) {
        // 函数因为「坐标 (r, c) 超出网格范围」返回，对应一条黄色的边
        if (!inArea(grid, r, c)) {
            return 1;
        }
        // 函数因为「当前格子是海洋格子」返回，对应一条蓝色的边
        if (grid[r][c] == 0) {
            return 1;
        }
        // 函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

}
