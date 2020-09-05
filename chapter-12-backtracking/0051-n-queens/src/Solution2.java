import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

    private Set<Integer> col;
    private Set<Integer> sub;
    private Set<Integer> main;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        col = new HashSet<>();
        sub = new HashSet<>();
        main = new HashSet<>();

        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !sub.contains(row + i) && !main.contains(row - i)) {
                path.addLast(i);
                col.add(i);
                sub.add(row + i);
                main.add(row - i);

                dfs(row + 1, path);

                main.remove(row - i);
                sub.remove(row + i);
                col.remove(i);
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