import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    private int n;
    // 记录某一列是否放置了皇后
    private boolean[] col;
    // 记录主对角线上的单元格是否放置了皇后
    private boolean[] sub;
    // 记录了副对角线上的单元格是否放置了皇后
    private boolean[] main;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        // 设置成员变量，减少参数传递，具体作为方法参数还是作为成员变量，请参考团队开发规范
        this.n = n;
        this.col = new boolean[n];
        this.sub = new boolean[2 * n - 1];
        this.main = new boolean[2 * n - 1];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            // 深度优先遍历到下标为 n，表示 [0.. n - 1] 已经填完，得到了一个结果
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }

        // 针对下标为 row 的每一列，尝试是否可以放置
        for (int j = 0; j < n; j++) {
            if (!col[j] && !sub[row + j] && !main[row - j + n - 1]) {
                path.addLast(j);
                col[j] = true;
                sub[row + j] = true;
                main[row - j + n - 1] = true;

                dfs(row + 1, path);

                main[row - j + n - 1] = false;
                sub[row + j] = false;
                col[j] = false;
                path.removeLast();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(".".repeat(Math.max(0, n)));
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }
}
