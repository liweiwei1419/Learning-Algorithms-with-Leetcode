public class Solution5 {

    // 国际版高赞题解，时间复杂度高

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    // trial. Try 1 through 9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            //Put c for this cell
                            board[i][j] = c;

                            if (solve(board)) {
                                //If it's the solution return true
                                return true;
                            } else {
                                //Otherwise go back
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                // check row
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                // check column
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                // check 3*3 block
                return false;
            }
        }
        return true;
    }
}
