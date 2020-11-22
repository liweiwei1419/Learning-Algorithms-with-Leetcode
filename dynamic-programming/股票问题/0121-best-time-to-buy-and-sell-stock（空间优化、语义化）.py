from typing import List


class Solution:

    def maxProfit(self, prices: List[int]) -> int:
        size = len(prices)
        if size < 2:
            return 0
        pre_min_val = prices[0]

        res = 0
        for i in range(1, size):
            pre_min_val = min(pre_min_val, prices[i])
            res = max(res, prices[i] - pre_min_val)
        return res