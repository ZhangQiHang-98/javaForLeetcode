package backTracing;

/**
 * @className: _37solveSudoku
 * @Description: 编写一个程序，通过填充空格来解决数独问题。
 * @author: Zhang Qihang
 * @date: 2021/11/15 20:23
 */
public class _37solveSudoku {

    public boolean backTracing(char[][] board) {
        // 此处的回溯逻辑，要在行和列上均遍历，因为数组是二维的

        // 遍历行
        for (int i = 0; i < 9; i++) {
            // 遍历列
            for (int j = 0; j < 9; j++) {
                // 如果当前位置已经有值，那么跳过该处
                if (board[i][j] != '.') {
                    continue;
                }
                // 在该处放数字k,如果当前不出错，至少可以找到一个k值
                for (char k = '1'; k <= '9'; k++) {
                    // 先判断是否合理，合理再放
                    if (isValidSudoku(i, j, k, board)) {
                        board[i][j] = k;
                        // 进行回溯
                        if (backTracing(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 如果一个k值也找不到，说明该数独无解。
                return false;
            }
        }
        return true;
    }


    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        backTracing(board);
    }
}
