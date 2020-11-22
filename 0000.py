class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1

        if n < 0:
            return 1 / self.myPow(x, -n)

        # 如果是奇数
        if n & 1:
            return x * self.myPow(x, n - 1)
        return self.myPow(x * x, n // 2)


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            # 负数变成正数
            n = -n

        res = 1
        while n:
            if n % 2:
                res *= x
            x *= x
            n //= 2
        return res
