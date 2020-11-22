class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def rob(self, root: TreeNode) -> int:
        def dfs(node):
            if node is None:
                return [0, 0]

            left = dfs(node.left)
            right = dfs(node.right)

            dp = [0, 0]
            dp[0] = max(left[0], left[1]) + max(right[0], right[1])
            dp[1] = node.val + left[0] + right[0]
            return dp

        res = dfs(root)
        return max(res)
