class Solution:

    # 方法一：递归

    def myPow(self, x: float, n: int) -> float:
        if n >= 0:
            return self.divide(x, n)
        else:
            return 1 / self.divide(x, -n)

    def divide(self, x, n):
        if n == 0:
            return 1.0
        sub_result = self.myPow(x, n // 2)

        if n % 2:
            res = sub_result * sub_result * x
        else:
            res = sub_result * sub_result
        return res