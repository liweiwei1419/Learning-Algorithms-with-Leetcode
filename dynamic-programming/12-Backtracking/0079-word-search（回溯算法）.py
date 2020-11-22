class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        n = len(board)
        m = len(board[0])

        def dfs(index, x, y):
            if index == len(word) - 1:
                return True
            for p, q in [[x + 1, y], [x - 1, y], [x, y + 1], [x, y - 1]]:
                if 0 <= p < n and 0 <= q < m and board[p][q] == word[index + 1]:
                    board[p][q] = -1
                    if dfs(index + 1, p, q):
                        return True
                    board[p][q] = word[index + 1]
            return False

        for i in range(n):
            for j in range(m):
                if board[i][j] == word[0]:
                    board[i][j] = -1
                    if dfs(0, i, j):
                        return True
                    board[i][j] = word[0]
        return False
