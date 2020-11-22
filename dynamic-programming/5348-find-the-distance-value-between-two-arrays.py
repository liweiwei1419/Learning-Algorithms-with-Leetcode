from typing import List


class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:

        min_val1 = min(arr1)
        min_val2 = min(arr2)

        print(min_val1)
        print(min_val2)

        max_val1 = max(arr1)
        max_val2 = max(arr2)

        print(max_val1)
        print(max_val2)

        return 0


if __name__ == '__main__':
    solution = Solution()
    # arr1 = [4, 5, 8]
    # arr2 = [10, 9, 1, 8]
    # d = 2

    arr1 = [2, 1, 100, 3]
    arr2 = [-5, -2, 10, -3, 7]
    d = 6

    res = solution.findTheDistanceValue(arr1,arr2,d)
    print(res)