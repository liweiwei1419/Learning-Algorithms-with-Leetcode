from typing import List


class Solution:
    def maxSumRangeQuery(self, nums: List[int], requests: List[List[int]]) -> int:

        size = len(nums)
        freq = [0 for _ in range(size)]

        for i in range(len(requests)):
            begin = requests[i][0]
            end = requests[i][1]

            for i in range(begin, end + 1):
                freq[i] += 1

        freq.sort()
        nums.sort()
        mod = 1000000000 + 7

        sum = 0
        for i in range(size - 1, -1, -1):
            if freq[i] == 0:
                break
            else:
                sum = (sum + (freq[i] * nums[i]) % mod) % mod
        return sum
