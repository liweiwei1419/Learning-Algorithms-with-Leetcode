from typing import List


class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(nums, begin, path, res):
            if len(path) >= 2:
                # 转换成 tuple 类型，才可以在结果集中去重
                res.append(tuple(path + []))

            for i in range(begin, len(nums)):
                if i > begin and nums[i] == nums[i - 1]:
                    continue
                if path and nums[i] < path[-1]:
                    continue
                path.append(nums[i])
                dfs(nums, i + 1, path, res)
                path.pop()

        dfs(nums, 0, [], res)
        return list(set(res))