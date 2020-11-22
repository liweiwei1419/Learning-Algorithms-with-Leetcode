from typing import List


class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        def backtracking(num, sum, path):
            if sum == 0 and len(path) == k:  # 找到了正确的解
                res.append(path[:])  # 注意要切片一下。相当于复制了一遍内容。
                return

            if num == 10:  # 1~9查完了
                return
            
            if sum < 0:  # 数组和大于n了
                return

            if len(path) > k:  # 数组长度大于k了
                return

            backtracking(num + 1, sum, path)  # 没选择这个数
            backtracking(num + 1, sum - num, path + [num])  # 选了这个数

        res = []
        backtracking(1, n, [])
        return res
