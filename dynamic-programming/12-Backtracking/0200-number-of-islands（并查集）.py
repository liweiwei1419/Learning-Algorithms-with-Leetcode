from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        class UnionFind:
            def __init__(self, n):
                self.count = n
                self.parent = [i for i in range(n)]

            def get_count(self):
                return self.count

            def find(self, p):
                while p != self.parent[p]:
                    self.parent[p] = self.parent[self.parent[p]]
                    p = self.parent[p]
                return p

            def union(self, p, q):
                p_root = self.find(p)
                q_root = self.find(q)
                if p_root == q_root:
                    return
                self.parent[p_root] = q_root
                self.count -= 1

        row = len(grid)
        if row == 0:
            return 0
        col = len(grid[0])

        def get_index(x, y):
            return x * col + y

        # 陆地的个数
        spaces = 0
        uf = UnionFind(row * col)

        # 1、统计陆地的个数；2、合并水域
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '0':
                    spaces += 1
                else:
                    if i + 1 < row and grid[i + 1][j] == '1':
                        uf.union(get_index(i, j), get_index(i + 1, j))
                    if j + 1 < col and grid[i][j + 1] == '1':
                        uf.union(get_index(i, j), get_index(i, j + 1))

        return uf.get_count() - spaces
