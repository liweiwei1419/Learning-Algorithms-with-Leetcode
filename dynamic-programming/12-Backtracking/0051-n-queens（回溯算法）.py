from typing import List


class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        def dfs(row, n, col, sub, main, path, res):
            if row == n:
                board = convert2board(path, n)
                res.append(board)
                return

            for i in range(n):
                if i not in col and row + i not in sub and row - i not in main:
                    path.append(i)
                    col.add(i)
                    sub.add(row + i)
                    main.add(row - i)

                    dfs(row + 1, n, col, sub, main, path, res)

                    main.remove(row - i)
                    sub.remove(row + i)
                    col.remove(i)
                    path.pop()

        def convert2board(path, n):
            return ["." * path[i] + "Q" + "." * (n - path[i] - 1) for i in range(n)]

        res = []
        if n == 0:
            return res

        col = set()
        main = set()
        sub = set()
        path = []

        dfs(0, n, col, main, sub, path, res)
        return res