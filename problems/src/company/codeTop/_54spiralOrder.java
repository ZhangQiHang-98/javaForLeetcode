package company.codeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: _54spiralOrder
 * @Description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
 * @author: Zhang Qihang
 * @date: 2022/3/22 11:26
 */
public class _54spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        // 异常情况
        if (matrix == null) {
            return res;
        }
        // m,n
        int m = matrix.length;
        int n = matrix[0].length;
        // 定义四个边界
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int cur = 0;
        while (cur < m * n) {
            // 从左往右
            for (int i = left; i <= right && cur < m * n; i++) {
                res.add(matrix[top][i]);
                cur++;
            }
            top++;
            // 从上到下
            for (int i = top; i <= bottom && cur < m * n; i++) {
                res.add(matrix[i][right]);
                cur++;
            }
            right--;
            // 从右到左
            for (int i = right; i >= left && cur < m * n; i--) {
                res.add(matrix[bottom][i]);
                cur++;
            }
            bottom--;
            // 从下到上
            for (int i = bottom; i >= top && cur < m * n; i--) {
                res.add(matrix[i][left]);
                cur++;
            }
            left++;
        }
        return res;
    }
}
