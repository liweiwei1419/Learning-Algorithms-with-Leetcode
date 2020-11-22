# a[i] = a[i-1] + a[i-2]+...+a[i-k+0]
# a[i+1] = a[i] + a[i-1]+...+a[i-k+1]

# a[i+1] = 2*a[i]-a[i-k]
# a[i] = 2*a[i - 1]-a[i - 1 - k]
if __name__ == '__main__':
    k, n = map(int, input().split())
    dp = [1] * k + [0] * (n - k + 1)
    for j in range(1, k + 1):
        dp[k] += dp[k - j]

    for i in range(k + 1, n + 1):
        dp[i] = (2 * dp[i - 1] - dp[i - 1 - k]) % 397

    print(dp[n])
