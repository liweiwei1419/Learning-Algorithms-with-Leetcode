public class Solution {

    // 递归终止条件混乱

    /**
     * 判断每一行是否被填上了数字，设置成 10 是为了让 '1' 落在下标 1 的位置，'9' 落在下标 9 的位置
     */
    private boolean[][] row = new boolean[9][10];
    private boolean[][] col = new boolean[9][10];
    private boolean[][][] box = new boolean[3][3][10];

    public void solveSudoku(char[][] board) {
        // 题目说：给定数独永远是 9 x 9 形式的，因此不用做特殊判断
        // 步骤 1：先遍历棋盘一次，然后每一行，每一列在 row col cell 里占住位置
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 减去 '0' 是有 1 个位置的偏移
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i / 3][j / 3][num] = true;
                }
            }
        }

        // 步骤 2：进行一次深度优先遍历，尝试所有的可能性
        dfs(board, 0, 0);
    }


    /**
     * @param board
     * @param x     横坐标
     * @param y     纵坐标
     * @return
     */
    private boolean dfs(char[][] board, int x, int y) {
        // 递归终止条件：一行填写完成以后，列数归 0，行数加 1
        // 注意：y == 9 和 x == 9 这两条判断语句不能交换
        if (y == 9) {
            x++;
            y = 0;
        }

        // 横坐标越界，即 x == 9 的时候找到了解
        if (x == 9) {
            return true;
        }

        if (board[x][y] != '.') {
            // 不是 '.' 的时候，右移一格继续检测
            return dfs(board, x, y + 1);
        }

        // 当 board[x][y] 是 '.' 的时候，从数字 1 到 9 去尝试
        for (int next = 1; next <= 9; next++) {
            // 注意：这里在剪枝
            if (row[x][next] || col[y][next] || box[x / 3][y / 3][next]) {
                continue;
            }

            board[x][y] = (char) ('0' + next);

            row[x][next] = true;
            col[y][next] = true;
            box[x / 3][y / 3][next] = true;

            if (dfs(board, x, y + 1)) {
                return true;
            }

            // 撤销选择，需要恢复成 '.' 以尝试下一个数字
            board[x][y] = '.';
            row[x][next] = false;
            col[y][next] = false;
            box[x / 3][y / 3][next] = false;
        }
        return false;
    }
}
