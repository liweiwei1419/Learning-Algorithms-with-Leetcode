from typing import List


class Solution:

    def maxProfit(self, prices: List[int]) -> int:
        size = len(prices)
        if size < 2:
            return 0

        dp = [[None for _ in range(2)] for _ in range(size)]

        dp[0][0] = 0
        dp[0][1] = -prices[0]

        for i in range(1, size):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], - prices[i])
        return dp[size - 1][0]
