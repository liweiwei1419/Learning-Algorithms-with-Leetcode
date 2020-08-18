public class Solution3 {

    boolean[][] row;
    boolean[][] col;
    boolean[][] box;

    public void solveSudoku(char[][] board) {
        row = new boolean[9][9];
        col = new boolean[9][9];
        box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 计算在布尔数值中的下标
                    int index = board[i][j] - '1';

                    // 在下标为 i 这一行，看到数值 board[i][j] - '1' ，记录为 true
                    row[i][index] = true;
                    // 在下标为 j 这一列，看到数值 board[i][j] - '1' ，记录为 true
                    col[j][index] = true;
                    // 在下标为 i / 3 * 3 + j / 3 的地方，看到数值 board[i][j] - '1'
                    box[i / 3 * 3 + j / 3][index] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j) {
        if (i > 8) {
            return true;
        }

        // 对 '.' 尝试从 1 填到 9
        if (board[i][j] != '.') {
            // ① 只需找到一个解即可，继续填写下一格 i + (j + 1) / 9 表示如果 j 已经在一列的末尾，跳转到下一行
            return dfs(board, i + (j + 1) / 9, (j + 1) % 9);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果行、列、box 已经填了 ch - '1' 则尝试下一个数字
            if (row[i][ch - '1'] || col[j][ch - '1'] || box[i / 3 * 3 + j / 3][ch - '1']) {
                continue;
            }

            // 填写当前字符，并且对应 row、col、box 占位
            board[i][j] = ch;
            row[i][ch - '1'] = true;
            col[j][ch - '1'] = true;
            box[i / 3 * 3 + j / 3][ch - '1'] = true;

            // 填写下一格和 ① 一样
            if (dfs(board, i + (j + 1) / 9, (j + 1) % 9)) {
                return true;
            }

            // 重置变量
            board[i][j] = '.';
            row[i][ch - '1'] = false;
            col[j][ch - '1'] = false;
            box[i / 3 * 3 + j / 3][ch - '1'] = false;
        }
        // 全部尝试过以后，返回 false
        return false;
    }
}
