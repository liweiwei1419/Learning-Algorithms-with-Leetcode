import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    private int n;
    private boolean[] col;
    private boolean[] main;
    private boolean[] sub;
    private List<List<String>> res;


    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        this.n = n;

        col = new boolean[n];
        main = new boolean[2 * n - 1];
        sub = new boolean[2 * n - 1];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        // 深度优先遍历到下标为 n，表示 [0.. n - 1] 已经填完，得到了一个结果集
        if (row == n) {
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }

        // 针对下标为 row 的每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col[i] && !main[row + i] && !sub[row - i + n - 1]) {
                path.addLast(i);
                col[i] = true;
                main[row + i] = true;
                sub[row - i + n - 1] = true;

                dfs(row + 1, path);

                sub[row - i + n - 1] = false;
                main[row + i] = false;
                col[i] = false;
                path.removeLast();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(".".repeat(Math.max(0, n)));
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }
}
