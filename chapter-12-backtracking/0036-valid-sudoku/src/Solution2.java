public class Solution2 {

    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[][] cell = new int[3][3];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 注意 1：'.' 的时候跳过
                if (board[i][j] == '.') {
                    continue;
                }

                // 注意 2：这里转换成整型数值 0 - 8
                int num = board[i][j] - '1';

                // 注意 3：cell[i / 3][j / 3] 下标的变化
                boolean rowExists = ((row[i] >> num) & 1) == 1;
                boolean colExists = ((col[j] >> num) & 1) == 1;
                boolean cellExists = ((cell[i / 3][j / 3] >> num) & 1) == 1;

                if (rowExists || colExists || cellExists) {
                    return false;
                }
                row[i] ^= 1 << num;
                col[j] ^= 1 << num;
                cell[i / 3][j / 3] ^= 1 << num;
            }
        }
        return true;
    }
}
