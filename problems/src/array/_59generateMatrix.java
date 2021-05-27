package array;

public class _59generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 定义四个边界值,同样遵循左闭右开的原则
        int left = 0, right = n - 1, top = 0, bottom = n - 1, cnt = 1, target = n * n;
        while (cnt <= target) {
            for (int i = left; i <= right; i++) {
                res[top][i] = cnt++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = cnt++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = cnt++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = cnt++;
            }
            left++;
        }
        return res;
    }
}
