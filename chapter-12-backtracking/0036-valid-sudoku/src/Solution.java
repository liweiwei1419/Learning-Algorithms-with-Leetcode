public class Solution {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][][] box = new boolean[3][3][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 注意 1：'.' 的时候跳过
                if (board[i][j] == '.') {
                    continue;
                }

                // 注意 2：这里转换成整型数值
                int num = board[i][j] - '0';

                // 注意 3：box[i / 3][j / 3] 下标的变化
                if (row[i][num] || col[j][num] || box[i / 3][j / 3][num]) {
                    return false;
                }
                row[i][num] = true;
                col[j][num] = true;
                box[i / 3][j / 3][num] = true;
            }
        }
        return true;
    }
}
