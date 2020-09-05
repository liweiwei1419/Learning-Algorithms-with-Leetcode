public class Solution2 {

    // 递归终止条件混乱

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        // 第 1 步：数据预处理
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] != '.') {
                    int num = board[x][y] - '0';
                    row[x][num] = true;
                    col[y][num] = true;

                    int boxIndex = 3 * (x / 3) + y / 3;
                    box[boxIndex][num] = true;
                }
            }
        }

        // 深度优先遍历
        dfs(board, 0, 0, row, col, box);
    }

    /**
     * 从左往右，从上到下
     *
     * @param board
     * @param y
     * @param x
     * @param row
     * @param col
     * @param box
     * @return
     */
    public boolean dfs(char[][] board, int x, int y, boolean[][] row, boolean[][] col, boolean[][] box) {
        // 顺序不能错，这个在最前面
        if (y == 9) {
            x++;
            y = 0;
        }
        if (x == 9) {
            return true;
        }

        if (board[x][y] != '.') {
            // 关键
            return dfs(board, x, y + 1, row, col, box);
        }
        for (int i = 1; i <= 9; i++) {

            if (!row[x][i] && !col[y][i] && !box[3 * (x / 3) + y / 3][i]) {
                row[x][i] = true;
                col[y][i] = true;
                box[3 * (x / 3) + y / 3][i] = true;

                board[x][y] = (char) (i + '0');
                if (dfs(board, x, y + 1, row, col, box)) {
                    return true;
                }
                row[x][i] = false;
                col[y][i] = false;
                box[3 * (x / 3) + y / 3][i] = false;
                board[x][y] = '.';
            }
        }

        return false;
    }
}
